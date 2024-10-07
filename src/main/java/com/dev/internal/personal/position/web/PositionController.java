package com.dev.internal.personal.position.web;

import com.dev.internal.personal.position.model.dto.request.PositionCreateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionUpdateRequest;
import com.dev.internal.personal.position.model.dto.request.PositionsFindRequest;
import com.dev.internal.personal.position.model.dto.response.PositionResponse;
import com.dev.internal.personal.position.model.dto.response.PositionsPageResponse;
import com.dev.internal.personal.position.usecase.PositionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/departments/teams")
public class PositionController {
    private final PositionUseCase positionUseCase;

    @PostMapping(value = "{teamId}/positions")
    @ResponseStatus(HttpStatus.CREATED)
    public PositionResponse createPosition(@PathVariable(name = "teamId") UUID teamId,
                                           @Valid @RequestBody PositionCreateRequest request) {
        return positionUseCase.createPosition(teamId, request);
    }

    @PatchMapping(value = "positions/{positionId}")
    public PositionResponse patchPosition(@PathVariable(name = "positionId") UUID positionId,
                                          @Valid @RequestBody PositionUpdateRequest request) {
        return positionUseCase.patchPosition(positionId, request);
    }

    @GetMapping(value = "positions/{positionId}")
    public PositionResponse getPositionById(@PathVariable(name = "positionId") UUID positionId) {
        return positionUseCase.getPositionById(positionId);
    }

    @GetMapping(value = "{teamId}/positions")
    public Set<PositionResponse> getAllPositionsByTeam(@PathVariable(name = "teamId") UUID teamId) {
        return positionUseCase.getAllPositionsByTeam(teamId);
    }

    @GetMapping(value = "positions/search")
    public PositionsPageResponse getPositions(@RequestParam(name = "page", defaultValue = "0") int page,
                                              @RequestParam(name = "limit", defaultValue = "10") int limit) {
        PositionsFindRequest request = new PositionsFindRequest(page, limit);
        return positionUseCase.getPositions(request);
    }

    @DeleteMapping(value = "positions/{positionId}")
    public void deletePositionById(@PathVariable(name = "positionId") UUID positionId) {
        positionUseCase.deletePositionById(positionId);
    }
}
