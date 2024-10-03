package com.dev.internal.personal.note.service;

import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.note.model.Note;

import java.util.Set;
import java.util.UUID;

public interface NoteService {
    Note createNote(Note note);

    Note updateNote(Note note);

    Note getNoteById(UUID noteId);

    Set<Note> getNotesByEmployee(Employee employee);

    void deleteNoteById(UUID noteId);
}
