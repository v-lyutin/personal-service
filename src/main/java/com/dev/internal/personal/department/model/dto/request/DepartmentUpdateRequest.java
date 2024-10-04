package com.dev.internal.personal.department.model.dto.request;

import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;

public record DepartmentUpdateRequest(
        @Size(max = 32, message = "The size of the 'displayName' field must not exceed 32 characters")
        JsonNullable<String> displayName,

        @Size(max = 256, message = "The size of the 'description' field must not exceed 256 characters")
        JsonNullable<String> description) {
}
