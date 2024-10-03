package com.dev.internal.personal.note.usecase;

import com.dev.internal.personal.note.model.dto.request.NoteCreateRequest;
import com.dev.internal.personal.note.model.dto.request.NoteUpdateRequest;
import com.dev.internal.personal.note.model.dto.response.NoteResponse;

import java.util.Set;
import java.util.UUID;

public interface NoteUseCase {
    NoteResponse addNoteToEmployee(UUID employeeId, NoteCreateRequest request);

    NoteResponse updateNote(UUID noteId, NoteUpdateRequest request);

    NoteResponse getNoteById(UUID noteId);

    Set<NoteResponse> getNotesByEmployee(UUID employeeId);

    void deleteNoteById(UUID noteId);
}
