package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.UNPROCESSABLE_ENTITY )
public class HttpUnprocessableEntityException extends CustomException {
    protected final boolean retryable;


    public HttpUnprocessableEntityException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpUnprocessableEntityException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
