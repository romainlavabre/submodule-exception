package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@ResponseStatus( code = HttpStatus.FORBIDDEN )
public class HttpForbiddenException extends CustomException {
    protected final boolean retryable;


    public HttpForbiddenException( String message ) {
        super( message );
        this.retryable = false;
    }


    public HttpForbiddenException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.FORBIDDEN;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
