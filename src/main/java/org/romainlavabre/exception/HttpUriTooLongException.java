package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.URI_TOO_LONG )
public class HttpUriTooLongException extends CustomException {
    protected final boolean retryable;


    public HttpUriTooLongException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpUriTooLongException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.URI_TOO_LONG;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
