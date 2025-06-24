package com.music.domain;

import jakarta.validation.constraints.NotBlank;

public record SignUpRequest(
        @NotBlank String loginId,
        @NotBlank String password,
        @NotBlank String username
) {
}
