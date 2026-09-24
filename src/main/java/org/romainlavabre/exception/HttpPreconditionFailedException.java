package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.PRECONDITION_FAILED )
public class HttpPreconditionFailedException extends CustomException {
    protected final boolean retryable;


    public HttpPreconditionFailedException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpPreconditionFailedException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.PRECONDITION_FAILED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
