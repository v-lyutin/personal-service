package com.dev.internal.personal.team.model.dto.response;

import java.util.UUID;

public record TeamResponse(
        UUID id,

        String displayName,

        String description,

        UUID departmentId,

        String departmentDisplayName,

        boolean isActive) {
}
