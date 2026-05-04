package org.romainlavabre.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.romainlavabre.exception.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * @author Romain Lavabre <romain.lavabre@proton.me>
 */
@RestControllerAdvice
public class ControllerAdvice {
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


    @ExceptionHandler( Exception.class )
    public ResponseEntity< Map< String, Object > > handleGeneric( Exception exception, HttpServletRequest request ) {
        return ResponseEntity.internalServerError().body( Map.of(
                "timestamp", ZonedDateTime.now( ZoneOffset.UTC ).toString(),
                "status", 500,
                "error", HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "message", "INTERNAL_SERVER_ERROR",
                "path", request.getRequestURI()
        ) );
    }
}
