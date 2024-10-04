package com.dev.internal.personal.department.model.dto.request;

import jakarta.validation.constraints.Size;

public record DepartmentCreateRequest(
        @Size(max = 32, message = "The size of the 'displayName' field must not exceed 32 characters")
        String displayName,

        @Size(max = 256, message = "The size of the 'description' field must not exceed 256 characters")
        String description) {
}
