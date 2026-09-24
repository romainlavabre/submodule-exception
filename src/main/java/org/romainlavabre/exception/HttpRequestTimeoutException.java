package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.REQUEST_TIMEOUT )
public class HttpRequestTimeoutException extends CustomException {
    protected final boolean retryable;


    public HttpRequestTimeoutException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpRequestTimeoutException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.REQUEST_TIMEOUT;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
