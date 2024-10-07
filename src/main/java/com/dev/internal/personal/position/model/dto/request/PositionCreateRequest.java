package com.dev.internal.personal.position.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PositionCreateRequest(
        @NotBlank(message = "The 'displayName' field must be not empty")
        @Size(max = 32, message = "The size of the 'displayName' field must not exceed 32 characters")
        String displayName,

        @Size(max = 256, message = "The size of the 'description' field must not exceed 256 characters")
        String description) {
}
