package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.CONTENT_TOO_LARGE )
public class HttpContentTooLargeException extends CustomException {
    protected final boolean retryable;


    public HttpContentTooLargeException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpContentTooLargeException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.CONTENT_TOO_LARGE;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
