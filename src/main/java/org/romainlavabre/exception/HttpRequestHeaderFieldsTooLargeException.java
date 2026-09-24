package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE )
public class HttpRequestHeaderFieldsTooLargeException extends CustomException {
    protected final boolean retryable;


    public HttpRequestHeaderFieldsTooLargeException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpRequestHeaderFieldsTooLargeException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
