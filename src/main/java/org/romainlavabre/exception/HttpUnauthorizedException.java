package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.UNAUTHORIZED )
public class HttpUnauthorizedException extends RuntimeException {
    public HttpUnauthorizedException( String message ) {
        super( message );
    }
}
