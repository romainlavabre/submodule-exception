package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Romain Lavabre <romain.lavabre@proton.me>
 */
public abstract class CustomException extends RuntimeException {
    public CustomException( String message ) {
        super( message );
    }


    abstract public HttpStatus getStatusCode();
}
