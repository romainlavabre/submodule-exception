package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.TOO_MANY_REQUESTS )
public class HttpTooManyRequestsException extends CustomException {
    protected final boolean retryable;


    public HttpTooManyRequestsException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpTooManyRequestsException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.TOO_MANY_REQUESTS;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
