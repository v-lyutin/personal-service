package com.dev.internal.personal.team.service.impl;

import com.dev.internal.common.exception.ServiceException;
import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.team.model.Team;
import com.dev.internal.personal.team.repository.TeamRepository;
import com.dev.internal.personal.team.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Team getTeamById(UUID teamId) {
        return teamRepository.findById(teamId)
                .orElseThrow(() -> new ServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Team with ID '%s' not found.", teamId)
                ));
    }

    @Override
    public Set<Team> getAllTeamsByDepartment(Department department) {
        return teamRepository.findAllByDepartment(department);
    }

    @Override
    public Team archiveTeam(Team team) {
        team.setIsActive(false);
        return teamRepository.save(team);
    }

    @Override
    public void deleteTeamById(UUID teamId) {
        teamRepository.deleteById(teamId);
    }
}
