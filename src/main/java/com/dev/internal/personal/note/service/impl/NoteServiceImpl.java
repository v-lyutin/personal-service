package com.dev.internal.personal.note.service.impl;

import com.dev.internal.common.exception.ServiceException;
import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.note.model.Note;
import com.dev.internal.personal.note.repository.NoteRepository;
import com.dev.internal.personal.note.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(UUID noteId) {
        return noteRepository.findById(noteId)
                .orElseThrow(() -> new ServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Note with ID '%s' not found.", noteId)
                ));
    }

    @Override
    public Set<Note> getNotesByEmployee(Employee employee) {
        return noteRepository.findAllByEmployee(employee);
    }

    @Override
    public void deleteNoteById(UUID noteId) {
        noteRepository.deleteById(noteId);
    }
}
