package com.dev.internal.personal.team.service;

import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.team.model.Team;

import java.util.Set;
import java.util.UUID;

public interface TeamService {
    Team createTeam(Team team);

    Team updateTeam(Team team);

    Team getTeamById(UUID teamId);

    Set<Team> getAllTeamsByDepartment(Department department);

    Team archiveTeam(Team team);

    void deleteTeamById(UUID teamId);
}
