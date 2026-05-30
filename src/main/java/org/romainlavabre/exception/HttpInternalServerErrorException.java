package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@ResponseStatus( code = HttpStatus.INTERNAL_SERVER_ERROR )
public class HttpInternalServerErrorException extends CustomException {

    protected final boolean retryable;


    public HttpInternalServerErrorException( String message ) {
        super( message );
        this.retryable = true;
        printStackTrace();
    }


    public HttpInternalServerErrorException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
        printStackTrace();
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
