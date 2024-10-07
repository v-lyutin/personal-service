package com.dev.internal.personal.position.mapper.impl;

import com.dev.internal.common.mapper.JsonNullableMapper;
import com.dev.internal.personal.position.mapper.PositionMapper;
import com.dev.internal.personal.position.model.Position;
import com.dev.internal.personal.position.model.dto.request.PositionCreateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionUpdateRequest;
import com.dev.internal.personal.position.model.dto.response.PositionResponse;
import com.dev.internal.personal.position.model.dto.response.PositionsPageResponse;
import com.dev.internal.personal.team.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PositionMapperImpl implements PositionMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Position toPosition(Team team, PositionCreateRequest request) {
        return Position.builder()
                .displayName(request.displayName())
                .description(request.description())
                .team(team)
                .build();
    }

    @Override
    public PositionResponse toPositionResponse(Position position) {
        Team team = position.getTeam();
        return new PositionResponse(
                position.getId(),
                position.getDisplayName(),
                position.getDescription(),
                team.getId(),
                team.getDisplayName(),
                team.getDepartment().getId(),
                team.getDepartment().getDisplayName()
        );
    }

    @Override
    public Position patch(Position position, PositionUpdateRequest request) {
        if (request != null) {
            if (jsonNullableMapper.isPresent(request.displayName())) {
                position.setDisplayName(jsonNullableMapper.unwrap(request.displayName()));
            }
            if (jsonNullableMapper.isPresent(request.description())) {
                position.setDescription(jsonNullableMapper.unwrap(request.description()));
            }
        }
        return position;
    }

    @Override
    public PositionsPageResponse toPositionsPageResponse(Page<Position> pageablePositions) {
        Set<PositionResponse> positions = pageablePositions.getContent().stream()
                .map(this::toPositionResponse)
                .collect(Collectors.toSet());
        return new PositionsPageResponse(
                pageablePositions.getTotalPages(),
                pageablePositions.isFirst(),
                pageablePositions.isLast(),
                pageablePositions.getTotalElements(),
                positions
        );
    }
}
