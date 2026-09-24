package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.UPGRADE_REQUIRED )
public class HttpUpgradeRequiredException extends CustomException {
    protected final boolean retryable;


    public HttpUpgradeRequiredException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpUpgradeRequiredException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.UPGRADE_REQUIRED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
