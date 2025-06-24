package com.music.domain.response;

public record ErrorResponse(
        int status,
        String errorCode,
        String message
) {
}
