package com.dev.internal.personal.note.repository;

import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.note.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    Set<Note> findAllByEmployee(Employee employee);
}
