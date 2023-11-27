package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Romain Lavabre <romainlavabre98@gmail.com>
 */
@ResponseStatus( code = HttpStatus.FORBIDDEN )
public class HttpForbiddenException extends RuntimeException {

    public HttpForbiddenException( String message ) {
        super( message );
    }
}
