package com.dev.internal.personal.team.mapper;

import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.team.model.Team;
import com.dev.internal.personal.team.model.dto.request.TeamCreateRequest;
import com.dev.internal.personal.team.model.dto.request.TeamUpdateRequest;
import com.dev.internal.personal.team.model.dto.response.TeamResponse;

public interface TeamMapper {
    Team toTeam(Department department, TeamCreateRequest request);

    TeamResponse toTeamResponse(Team team);

    Team patch(Team team, TeamUpdateRequest request);
}
