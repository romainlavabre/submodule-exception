package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.PRECONDITION_REQUIRED )
public class HttpPreconditionRequiredException extends CustomException {
    protected final boolean retryable;


    public HttpPreconditionRequiredException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpPreconditionRequiredException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.PRECONDITION_REQUIRED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
