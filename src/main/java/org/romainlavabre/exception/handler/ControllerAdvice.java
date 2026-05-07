package org.romainlavabre.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.romainlavabre.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author Romain Lavabre <romain.lavabre@proton.me>
 */
@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger( "ControllerAdvice" );


    @ExceptionHandler( CustomException.class )
    public ResponseEntity< Map< String, Object > > handleBusiness( CustomException customException, HttpServletRequest request ) {
        return ResponseEntity.status( customException.getStatusCode() ).body( Map.of(
                "timestamp", ZonedDateTime.now( ZoneOffset.UTC ).toString(),
                "status", customException.getStatusCode().value(),
                "error", customException.getStatusCode().getReasonPhrase(),
                "message", customException.getMessage(),
                "path", request.getRequestURI()
        ) );
    }


    @ExceptionHandler( NoResourceFoundException.class )
    public ResponseEntity< Map< String, Object > > handleResourceNotFound( NoResourceFoundException exception, HttpServletRequest request ) {
        return ResponseEntity.internalServerError().body( Map.of(
                "timestamp", ZonedDateTime.now( ZoneOffset.UTC ).toString(),
                "status", 404,
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", "RESOURCE_NOT_FOUND",
                "path", request.getRequestURI()
        ) );
    }


    @ExceptionHandler( Exception.class )
    public ResponseEntity< Map< String, Object > > handleGeneric( Exception exception, HttpServletRequest request ) {
        logger.info( "An unexpected error occurred ({}): {}", exception.getClass().getName(), exception.getMessage() );

        return ResponseEntity.internalServerError().body( Map.of(
                "timestamp", ZonedDateTime.now( ZoneOffset.UTC ).toString(),
                "status", 500,
                "error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "message", "INTERNAL_SERVER_ERROR",
                "path", request.getRequestURI()
        ) );
    }
}
