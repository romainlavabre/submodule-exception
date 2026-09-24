package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.FAILED_DEPENDENCY )
public class HttpFailedDependencyException extends CustomException {
    protected final boolean retryable;


    public HttpFailedDependencyException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpFailedDependencyException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.FAILED_DEPENDENCY;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
