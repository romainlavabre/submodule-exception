package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.LENGTH_REQUIRED )
public class HttpLengthRequiredException extends CustomException {
    protected final boolean retryable;


    public HttpLengthRequiredException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpLengthRequiredException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.LENGTH_REQUIRED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
