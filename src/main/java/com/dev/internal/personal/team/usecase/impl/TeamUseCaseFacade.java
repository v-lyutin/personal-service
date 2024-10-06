package com.dev.internal.personal.team.usecase.impl;

import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.department.service.DepartmentService;
import com.dev.internal.personal.team.mapper.TeamMapper;
import com.dev.internal.personal.team.model.Team;
import com.dev.internal.personal.team.model.dto.request.TeamCreateRequest;
import com.dev.internal.personal.team.model.dto.request.TeamUpdateRequest;
import com.dev.internal.personal.team.model.dto.response.TeamResponse;
import com.dev.internal.personal.team.service.TeamService;
import com.dev.internal.personal.team.usecase.TeamUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TeamUseCaseFacade implements TeamUseCase {
    private final TeamService teamService;
    private final DepartmentService departmentService;
    private final TeamMapper teamMapper;

    @Override
    public TeamResponse createTeam(UUID departmentId, TeamCreateRequest request) {
        Department department = departmentService.getDepartmentById(departmentId);
        Team team = teamMapper.toTeam(department, request);
        return teamMapper.toTeamResponse(teamService.createTeam(team));
    }

    @Override
    public TeamResponse patchTeam(UUID teamId, TeamUpdateRequest request) {
        Team team = teamService.getTeamById(teamId);
        team = teamMapper.patch(team, request);
        return teamMapper.toTeamResponse(teamService.updateTeam(team));
    }

    @Override
    public TeamResponse getTeamById(UUID teamId) {
        return teamMapper.toTeamResponse(teamService.getTeamById(teamId));
    }

    @Override
    public Set<TeamResponse> getAllTeamsByDepartment(UUID departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        return teamService.getAllTeamsByDepartment(department).stream()
                .map(teamMapper::toTeamResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public TeamResponse archiveTeam(UUID teamId) {
        Team team = teamService.getTeamById(teamId);
        return teamMapper.toTeamResponse(teamService.archiveTeam(team));
    }

    @Override
    public void deleteTeamById(UUID teamId) {
        teamService.deleteTeamById(teamId);
    }
}
