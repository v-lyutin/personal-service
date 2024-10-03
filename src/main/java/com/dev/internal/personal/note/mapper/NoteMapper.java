package com.dev.internal.personal.note.mapper;

import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.note.model.Note;
import com.dev.internal.personal.note.model.dto.request.NoteCreateRequest;
import com.dev.internal.personal.note.model.dto.response.NoteResponse;

public interface NoteMapper {
    Note toNote(Employee employee, NoteCreateRequest request);

    NoteResponse toNoteResponse(Note note);
}
