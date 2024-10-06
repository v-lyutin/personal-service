package com.dev.internal.personal.team.mapper.impl;

import com.dev.internal.common.mapper.JsonNullableMapper;
import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.team.mapper.TeamMapper;
import com.dev.internal.personal.team.model.Team;
import com.dev.internal.personal.team.model.dto.request.TeamCreateRequest;
import com.dev.internal.personal.team.model.dto.request.TeamUpdateRequest;
import com.dev.internal.personal.team.model.dto.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeamMapperImpl implements TeamMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Team toTeam(Department department, TeamCreateRequest request) {
        return Team.builder()
                .displayName(request.displayName())
                .description(request.description())
                .isActive(true)
                .department(department)
                .build();
    }

    @Override
    public TeamResponse toTeamResponse(Team team) {
        return new TeamResponse(
                team.getId(),
                team.getDisplayName(),
                team.getDescription(),
                team.getDepartment().getId(),
                team.getDepartment().getDisplayName(),
                team.getIsActive()
        );
    }

    @Override
    public Team patch(Team team, TeamUpdateRequest request) {
        if (request != null) {
            if (jsonNullableMapper.isPresent(request.displayName())) {
                team.setDisplayName(jsonNullableMapper.unwrap(request.displayName()));
            }
            if (jsonNullableMapper.isPresent(request.description())) {
                team.setDescription(jsonNullableMapper.unwrap(request.description()));
            }
        }
        return team;
    }
}
