package org.romainlavabre.exception.handler;

import jakarta.persistence.LockTimeoutException;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PessimisticLockException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.ConcurrencyFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Concurrency failures are expected under parallel writes: the caller replays on fresh data instead of reporting to Sentry.
 * Must run before {@link ControllerAdvice}, whose Exception handler would otherwise catch them as a 500.
 *
 * @author Romain Lavabre <romain.lavabre@proton.me>
 */
@RestControllerAdvice
@Order( Ordered.HIGHEST_PRECEDENCE )
@ConditionalOnClass( name = {
        "jakarta.persistence.OptimisticLockException",
        "org.springframework.dao.ConcurrencyFailureException"
} )
public class ConcurrencyControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger( "ErrorHandler" );


    // Spring translates at commit, but a flush outside a @Repository throws the raw JPA exceptions
    @ExceptionHandler( {
            ConcurrencyFailureException.class,
            OptimisticLockException.class,
            PessimisticLockException.class,
            LockTimeoutException.class
    } )
    public ResponseEntity< Map< String, Object > > handleConcurrency( Exception exception, HttpServletRequest request ) {
        logger.warn( "Concurrent modification on {} ({})", request.getRequestURI(), exception.getClass().getSimpleName() );

        return ResponseEntity.status( HttpStatus.CONFLICT ).body( Map.of(
                "timestamp", ZonedDateTime.now( ZoneOffset.UTC ).toString(),
                "status", 409,
                "error", HttpStatus.CONFLICT.getReasonPhrase(),
                "detail", "The resource was modified concurrently, retry the request",
                "message", "CONCURRENT_MODIFICATION",
                "path", request.getRequestURI(),
                "retryable", true
        ) );
    }
}
