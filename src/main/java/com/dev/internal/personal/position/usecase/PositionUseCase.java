package com.dev.internal.personal.position.usecase;

import com.dev.internal.personal.position.model.dto.request.PositionCreateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionUpdateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionsFindRequest;
import com.dev.internal.personal.position.model.dto.response.PositionResponse;
import com.dev.internal.personal.position.model.dto.response.PositionsPageResponse;
import org.springframework.validation.annotation.Validated;

import java.util.Set;
import java.util.UUID;

@Validated
public interface PositionUseCase {
    PositionResponse createPosition(UUID teamId, PositionCreateRequest request);

    PositionResponse patchPosition(UUID positionId, PositionUpdateRequest request);

    PositionResponse getPositionById(UUID positionId);

    Set<PositionResponse> getAllPositionsByTeam(UUID teamId);

    PositionsPageResponse getPositions(@Validated PositionsFindRequest request);

    void deletePositionById(UUID positionId);
}
