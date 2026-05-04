package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.TOO_EARLY )
public class HttpTooEarlyException extends CustomException {

    public HttpTooEarlyException( String message ) {
        super( message );
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.TOO_EARLY;
    }
}