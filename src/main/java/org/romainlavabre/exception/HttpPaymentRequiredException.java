package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.PAYMENT_REQUIRED )
public class HttpPaymentRequiredException extends CustomException {
    protected final boolean retryable;


    public HttpPaymentRequiredException( String message ) {
        super( message );
        this.retryable = false;
    }


    public HttpPaymentRequiredException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.PAYMENT_REQUIRED;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
