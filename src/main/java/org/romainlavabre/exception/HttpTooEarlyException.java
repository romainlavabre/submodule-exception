package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.TOO_EARLY )
public class HttpTooEarlyException extends CustomException {
    protected final boolean retryable;


    public HttpTooEarlyException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpTooEarlyException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.TOO_EARLY;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}