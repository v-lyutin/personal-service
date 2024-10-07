package com.dev.internal.personal.position.mapper;

import com.dev.internal.personal.position.model.Position;
import com.dev.internal.personal.position.model.dto.request.PositionCreateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionUpdateRequest;
import com.dev.internal.personal.position.model.dto.response.PositionResponse;
import com.dev.internal.personal.position.model.dto.response.PositionsPageResponse;
import com.dev.internal.personal.team.model.Team;
import org.springframework.data.domain.Page;

public interface PositionMapper {
    Position toPosition(Team team, PositionCreateRequest request);

    PositionResponse toPositionResponse(Position position);

    Position patch(Position position, PositionUpdateRequest request);

    PositionsPageResponse toPositionsPageResponse(Page<Position> pageablePositions);
}
