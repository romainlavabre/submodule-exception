package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@ResponseStatus( code = HttpStatus.BAD_REQUEST )
public class HttpBadRequestException extends CustomException {
    protected final boolean retryable;


    public HttpBadRequestException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpBadRequestException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.BAD_REQUEST;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
