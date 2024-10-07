package com.dev.internal.personal.position.usecase.impl;

import com.dev.internal.personal.position.mapper.PositionMapper;
import com.dev.internal.personal.position.model.Position;
import com.dev.internal.personal.position.model.dto.request.PositionCreateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionUpdateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionsFindRequest;
import com.dev.internal.personal.position.model.dto.response.PositionResponse;
import com.dev.internal.personal.position.model.dto.response.PositionsPageResponse;
import com.dev.internal.personal.position.service.PositionService;
import com.dev.internal.personal.position.usecase.PositionUseCase;
import com.dev.internal.personal.team.model.Team;
import com.dev.internal.personal.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PositionUseCaseFacade implements PositionUseCase {
    private final PositionService positionService;
    private final TeamService teamService;
    private final PositionMapper positionMapper;

    @Override
    public PositionResponse createPosition(UUID teamId, PositionCreateRequest request) {
        Team team = teamService.getTeamById(teamId);
        Position position = positionMapper.toPosition(team, request);
        return positionMapper.toPositionResponse(positionService.createTeam(position));
    }

    @Override
    public PositionResponse patchPosition(UUID positionId, PositionUpdateRequest request) {
        Position position = positionService.getPositionById(positionId);
        position = positionMapper.patch(position, request);
        return positionMapper.toPositionResponse(positionService.updatePosition(position));
    }

    @Override
    public PositionResponse getPositionById(UUID positionId) {
        return positionMapper.toPositionResponse(positionService.getPositionById(positionId));
    }

    @Override
    public Set<PositionResponse> getAllPositionsByTeam(UUID teamId) {
        Team team = teamService.getTeamById(teamId);
        return positionService.getAllPositionsByTeam(team).stream()
                .map(positionMapper::toPositionResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public PositionsPageResponse getPositions(PositionsFindRequest request) {
        Pageable pageable = PageRequest.of(request.page(), request.limit());
        return positionMapper.toPositionsPageResponse(positionService.getPositions(pageable));
    }

    @Override
    public void deletePositionById(UUID positionId) {
        positionService.deletePositionById(positionId);
    }
}
