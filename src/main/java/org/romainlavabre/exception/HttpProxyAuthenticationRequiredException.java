package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.PROXY_AUTHENTICATION_REQUIRED )
public class HttpProxyAuthenticationRequiredException extends CustomException {
    protected final boolean retryable;


    public HttpProxyAuthenticationRequiredException( String message ) {
        super( message );
        this.retryable = false;
    }


    public HttpProxyAuthenticationRequiredException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.PROXY_AUTHENTICATION_REQUIRED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
