package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_FOUND )
public class HttpNotFoundException extends CustomException {
    protected final boolean retryable;


    public HttpNotFoundException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpNotFoundException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
