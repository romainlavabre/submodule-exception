package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@ResponseStatus( code = HttpStatus.CONFLICT )
public class HttpConflictException extends CustomException {
    protected final boolean retryable;


    public HttpConflictException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpConflictException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONFLICT;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
