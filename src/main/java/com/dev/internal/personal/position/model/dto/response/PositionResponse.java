package com.dev.internal.personal.position.model.dto.response;

import java.util.UUID;

public record PositionResponse(
        UUID id,

        String displayName,

        String description,

        UUID teamId,

        String teamDisplayName,

        UUID departmentId,

        String departmentDisplayName) {
}
