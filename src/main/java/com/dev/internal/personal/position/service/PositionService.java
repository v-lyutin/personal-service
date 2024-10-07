package com.dev.internal.personal.position.service;

import com.dev.internal.personal.position.model.Position;
import com.dev.internal.personal.team.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.UUID;

public interface PositionService {
    Position createTeam(Position position);

    Position updatePosition(Position position);

    Position getPositionById(UUID positionId);

    Set<Position> getAllPositionsByTeam(Team team);

    Page<Position> getPositions(Pageable pageable);

    void deletePositionById(UUID positionId);
}
