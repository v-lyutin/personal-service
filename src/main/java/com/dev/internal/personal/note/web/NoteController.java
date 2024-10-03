package com.dev.internal.personal.note.web;

import com.dev.internal.personal.note.model.dto.request.NoteCreateRequest;
import com.dev.internal.personal.note.model.dto.request.NoteUpdateRequest;
import com.dev.internal.personal.note.model.dto.response.NoteResponse;
import com.dev.internal.personal.note.usecase.NoteUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/staff")
public class NoteController {
    private final NoteUseCase noteUseCase;

    @PostMapping(value = "{employeeId}/notes")
    @ResponseStatus(HttpStatus.CREATED)
    public NoteResponse addNoteToEmployee(@PathVariable(name = "employeeId") UUID employeeId,
                                          @Valid @RequestBody NoteCreateRequest request) {
        return noteUseCase.addNoteToEmployee(employeeId, request);
    }

    @PutMapping(value = "notes/{noteId}")
    public NoteResponse updateNote(@PathVariable(name = "noteId") UUID noteId,
                                   @Valid @RequestBody NoteUpdateRequest request) {
        return noteUseCase.updateNote(noteId, request);
    }

    @GetMapping(value = "notes/{noteId}")
    public NoteResponse getNoteById(@PathVariable(name = "noteId") UUID noteId) {
        return noteUseCase.getNoteById(noteId);
    }

    @GetMapping(value = "{employeeId}/notes")
    public Set<NoteResponse> getNotesByEmployee(@PathVariable(name = "employeeId") UUID employeeId) {
        return noteUseCase.getNotesByEmployee(employeeId);
    }

    @DeleteMapping(value = "notes/{noteId}")
    public void deleteNoteById(@PathVariable(name = "noteId") UUID noteId) {
        noteUseCase.deleteNoteById(noteId);
    }
}
