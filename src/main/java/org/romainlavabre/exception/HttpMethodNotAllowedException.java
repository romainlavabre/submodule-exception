package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.METHOD_NOT_ALLOWED )
public class HttpMethodNotAllowedException extends CustomException {
    protected final boolean retryable;


    public HttpMethodNotAllowedException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpMethodNotAllowedException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.METHOD_NOT_ALLOWED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
