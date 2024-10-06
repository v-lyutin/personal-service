package com.dev.internal.personal.team.web;

import com.dev.internal.personal.team.model.dto.request.TeamCreateRequest;
import com.dev.internal.personal.team.model.dto.request.TeamUpdateRequest;
import com.dev.internal.personal.team.model.dto.response.TeamResponse;
import com.dev.internal.personal.team.usecase.TeamUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/departments")
public class TeamController {
    private final TeamUseCase teamUseCase;

    @PostMapping(value = "{departmentId}/teams")
    @ResponseStatus(HttpStatus.CREATED)
    public TeamResponse createTeam(@PathVariable(name = "departmentId") UUID departmentId,
                                   @Valid @RequestBody TeamCreateRequest request) {
        return teamUseCase.createTeam(departmentId, request);
    }

    @PatchMapping(value = "teams/{teamId}")
    public TeamResponse patchTeam(@PathVariable(name = "teamId") UUID teamId,
                                        @Valid @RequestBody TeamUpdateRequest request) {
        return teamUseCase.patchTeam(teamId, request);
    }

    @GetMapping(value = "teams/{teamId}")
    public TeamResponse getTeamById(@PathVariable(name = "teamId") UUID teamId) {
        return teamUseCase.getTeamById(teamId);
    }

    @GetMapping(value = "{departmentId}/teams")
    public Set<TeamResponse> getAllTeamsByDepartment(@PathVariable(name = "departmentId") UUID departmentId) {
        return teamUseCase.getAllTeamsByDepartment(departmentId);
    }

    @PutMapping(value = "teams/{teamId}")
    public TeamResponse archiveTeam(@PathVariable(name = "teamId") UUID teamId) {
        return teamUseCase.archiveTeam(teamId);
    }

    @DeleteMapping(value = "teams/{teamId}")
    public void deleteTeamById(@PathVariable(name = "teamId") UUID teamId) {
        teamUseCase.deleteTeamById(teamId);
    }
}
