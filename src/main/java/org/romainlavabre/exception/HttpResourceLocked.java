package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.LOCKED )
public class HttpResourceLocked extends RuntimeException {
    public HttpResourceLocked( String message ) {
        super( message );
    }
}
