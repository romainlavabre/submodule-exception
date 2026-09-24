package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE )
public class HttpRangeNotSatisfiableException extends CustomException {
    protected final boolean retryable;


    public HttpRangeNotSatisfiableException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpRangeNotSatisfiableException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
