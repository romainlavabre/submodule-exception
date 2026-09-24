package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.GONE )
public class HttpGoneException extends CustomException {
    protected final boolean retryable;


    public HttpGoneException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpGoneException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.GONE;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
