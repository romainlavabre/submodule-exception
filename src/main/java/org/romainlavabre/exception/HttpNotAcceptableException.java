package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.NOT_ACCEPTABLE )
public class HttpNotAcceptableException extends CustomException {
    protected final boolean retryable;


    public HttpNotAcceptableException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpNotAcceptableException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_ACCEPTABLE;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
