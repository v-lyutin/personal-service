package com.dev.internal.personal.department.model.dto.response;

import java.util.UUID;

public record DepartmentResponse(
        UUID id,

        String displayName,

        String description,

        boolean isActive) {
}
