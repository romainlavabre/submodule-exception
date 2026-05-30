package org.romainlavabre.exception.config;

import jakarta.annotation.Nullable;

/**
 * @author Romain Lavabre <romain.lavabre@proton.me>
 */
public interface ErrorDetail {

    @Nullable
    String getDetail( String error );
}
