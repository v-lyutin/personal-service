package com.dev.internal.personal.note.usecase.impl;

import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.employee.service.EmployeeService;
import com.dev.internal.personal.note.mapper.NoteMapper;
import com.dev.internal.personal.note.model.Note;
import com.dev.internal.personal.note.model.dto.request.NoteCreateRequest;
import com.dev.internal.personal.note.model.dto.request.NoteUpdateRequest;
import com.dev.internal.personal.note.model.dto.response.NoteResponse;
import com.dev.internal.personal.note.service.NoteService;
import com.dev.internal.personal.note.usecase.NoteUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class NoteUseCaseFacade implements NoteUseCase {
    private final NoteService noteService;
    private final EmployeeService employeeService;
    private final NoteMapper noteMapper;

    @Override
    public NoteResponse addNoteToEmployee(UUID employeeId, NoteCreateRequest request) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        Note note = noteService.createNote(noteMapper.toNote(employee, request));
        return noteMapper.toNoteResponse(note);
    }

    @Override
    public NoteResponse updateNote(UUID noteId, NoteUpdateRequest request) {
        Note note = noteService.getNoteById(noteId);
        note.setText(request.text());
        return noteMapper.toNoteResponse(noteService.updateNote(note));
    }

    @Override
    public NoteResponse getNoteById(UUID noteId) {
        return noteMapper.toNoteResponse(noteService.getNoteById(noteId));
    }

    @Override
    public Set<NoteResponse> getNotesByEmployee(UUID employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return noteService.getNotesByEmployee(employee).stream()
                .map(noteMapper::toNoteResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public void deleteNoteById(UUID noteId) {
        noteService.deleteNoteById(noteId);
    }
}
