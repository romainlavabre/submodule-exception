package org.romainlavabre.exception.handler;

import jakarta.persistence.LockTimeoutException;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PessimisticLockException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.dao.PessimisticLockingFailureException;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ConcurrencyControllerAdviceTest {

    static Stream< Arguments > concurrencyFailures() {
        return Stream.of(
                Arguments.of( new OptimisticLockingFailureException( "Row was updated by another transaction" ) ),
                Arguments.of( new PessimisticLockingFailureException( "Deadlock found" ) ),
                Arguments.of( new OptimisticLockException() ),
                Arguments.of( new PessimisticLockException() ),
                Arguments.of( new LockTimeoutException() )
        );
    }


    @ParameterizedTest
    @MethodSource( "concurrencyFailures" )
    void concurrency_failure_is_a_retryable_conflict( Exception exception ) {
        MockHttpServletRequest request = new MockHttpServletRequest( "PATCH", "/system/orders/1/end_initiator" );

        ResponseEntity< Map< String, Object > > response = new ConcurrencyControllerAdvice().handleConcurrency( exception, request );

        assertThat( response.getStatusCode().value() ).isEqualTo( 409 );
        assertThat( response.getBody() )
                .containsEntry( "status", 409 )
                .containsEntry( "message", "CONCURRENT_MODIFICATION" )
                .containsEntry( "path", "/system/orders/1/end_initiator" )
                .containsEntry( "retryable", true );
    }
}
