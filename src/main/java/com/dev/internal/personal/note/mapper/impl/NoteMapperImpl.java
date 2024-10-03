package com.dev.internal.personal.note.mapper.impl;

import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.note.mapper.NoteMapper;
import com.dev.internal.personal.note.model.Note;
import com.dev.internal.personal.note.model.dto.request.NoteCreateRequest;
import com.dev.internal.personal.note.model.dto.response.NoteResponse;
import org.springframework.stereotype.Component;

@Component
public class NoteMapperImpl implements NoteMapper {
    @Override
    public Note toNote(Employee employee, NoteCreateRequest request) {
        return Note.builder()
                .text(request.text())
                .employee(employee)
                .build();
    }

    @Override
    public NoteResponse toNoteResponse(Note note) {
        return new NoteResponse(
                note.getId(),
                note.getText(),
                note.getCreatedAt(),
                note.getEditedAt(),
                note.getEmployee().getId()
        );
    }
}
