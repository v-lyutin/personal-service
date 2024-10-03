package com.dev.internal.personal.note.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;
import java.util.UUID;

public record NoteResponse(
        UUID id,

        String text,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant createdAt,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
        Instant editedAt,

        UUID employeeId) {
}
