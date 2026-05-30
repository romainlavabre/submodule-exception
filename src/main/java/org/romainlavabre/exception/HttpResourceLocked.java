package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.LOCKED )
public class HttpResourceLocked extends CustomException {
    protected final boolean retryable;


    public HttpResourceLocked( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpResourceLocked( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.LOCKED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
