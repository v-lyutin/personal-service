package com.dev.internal.personal.note.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record NoteCreateRequest(
        @NotBlank(message = "The 'text' field must be not empty")
        @Size(max = 256, message = "The size of the 'text' field must not exceed 256 characters")
        String text) {
}
