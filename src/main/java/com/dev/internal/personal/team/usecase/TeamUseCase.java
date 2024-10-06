package com.dev.internal.personal.team.usecase;

import com.dev.internal.personal.team.model.dto.request.TeamCreateRequest;
import com.dev.internal.personal.team.model.dto.request.TeamUpdateRequest;
import com.dev.internal.personal.team.model.dto.response.TeamResponse;

import java.util.Set;
import java.util.UUID;

public interface TeamUseCase {
    TeamResponse createTeam(UUID departmentId, TeamCreateRequest request);

    TeamResponse patchTeam(UUID teamId, TeamUpdateRequest request);

    TeamResponse getTeamById(UUID teamId);

    Set<TeamResponse> getAllTeamsByDepartment(UUID departmentId);

    TeamResponse archiveTeam(UUID teamId);

    void deleteTeamById(UUID teamId);
}
