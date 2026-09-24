package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.UNSUPPORTED_MEDIA_TYPE )
public class HttpUnsupportedMediaTypeException extends CustomException {
    protected final boolean retryable;


    public HttpUnsupportedMediaTypeException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpUnsupportedMediaTypeException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.UNSUPPORTED_MEDIA_TYPE;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
