package com.dev.internal.personal.position.service.impl;

import com.dev.internal.common.exception.ServiceException;
import com.dev.internal.personal.position.model.Position;
import com.dev.internal.personal.position.repository.PositionRepository;
import com.dev.internal.personal.position.service.PositionService;
import com.dev.internal.personal.team.model.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {
    private final PositionRepository positionRepository;

    @Override
    public Position createTeam(Position position) {
        if (!position.getTeam().getIsActive()) {
            throw new ServiceException(
                    HttpStatus.BAD_REQUEST,
                    "Team is not active"
            );
        }
        return positionRepository.save(position);
    }

    @Override
    public Position updatePosition(Position position) {
        return positionRepository.save(position);
    }

    @Override
    public Position getPositionById(UUID positionId) {
        return positionRepository.findById(positionId)
                .orElseThrow(() -> new ServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Position with ID '%s' not found.", positionId)
                ));
    }

    @Override
    public Set<Position> getAllPositionsByTeam(Team team) {
        return positionRepository.findAllByTeam(team);
    }

    @Override
    public Page<Position> getPositions(Pageable pageable) {
        return positionRepository.findAll(pageable);
    }

    @Override
    public void deletePositionById(UUID positionId) {
        positionRepository.deleteById(positionId);
    }
}
