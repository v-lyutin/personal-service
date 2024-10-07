package com.dev.internal.personal.position.model.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record PositionsFindRequest(
        @Min(value = 0, message = "Page must be positive")
        int page,

        @Min(value = 10, message = "The minimum limit is 10")
        @Max(value = 25, message = "The maximum limit is 25")
        int limit) {
}
