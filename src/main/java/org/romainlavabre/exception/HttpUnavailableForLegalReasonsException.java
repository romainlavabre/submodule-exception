package org.romainlavabre.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( code = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS )
public class HttpUnavailableForLegalReasonsException extends CustomException {
    protected final boolean retryable;


    public HttpUnavailableForLegalReasonsException( String message ) {
        super( message );
        this.retryable = true;
    }


    public HttpUnavailableForLegalReasonsException( String message, boolean retryable ) {
        super( message );
        this.retryable = retryable;
    }


    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS;
    }


    @Override
    public boolean retryable() {
        return retryable;
    }
}
