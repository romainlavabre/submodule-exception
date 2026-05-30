package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.UNAUTHORIZED )
public class HttpUnauthorizedException extends CustomException {
    protected final boolean retryable;


    public HttpUnauthorizedException( String message ) {
        super( message );
        this.retryable = false;
    }


    public HttpUnauthorizedException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.UNAUTHORIZED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
