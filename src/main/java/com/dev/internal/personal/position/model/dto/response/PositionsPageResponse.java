package com.dev.internal.personal.position.model.dto.response;

import java.util.Set;

public record PositionsPageResponse(
        long totalPages,

        boolean isFirstPage,

        boolean isLastPage,

        long positionsCount,

        Set<PositionResponse> positions) {
}
