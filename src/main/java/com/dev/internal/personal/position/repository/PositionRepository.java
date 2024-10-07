package com.dev.internal.personal.position.repository;

import com.dev.internal.personal.position.model.Position;
import com.dev.internal.personal.team.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface PositionRepository extends JpaRepository<Position, UUID> {
    Set<Position> findAllByTeam(Team team);
}
