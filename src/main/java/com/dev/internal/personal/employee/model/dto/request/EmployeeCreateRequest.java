package com.dev.internal.personal.employee.model.dto.request;

import com.dev.internal.personal.employee.model.enums.Gender;
import com.dev.internal.personal.employee.util.GenderDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record EmployeeCreateRequest(
        @NotBlank(message = "The 'firstName' field must be not empty")
        @Size(max = 32, message = "The size of the 'firstName' field must not exceed 32 characters")
        String firstName,

        @NotBlank(message = "The 'lastName' field must be not empty")
        @Size(max = 32, message = "The size of the 'lastName' field must not exceed 32 characters")
        String lastName,

        @Size(max = 32, message = "The size of the 'middleName' field must not exceed 32 characters")
        String middleName,

        @NotNull(message = "The 'dateOfBirth' field must be not empty")
        @PastOrPresent(message = "Date of birth from the future")
        LocalDate dateOfBirth,

        @NotNull(message = "The 'gender' field must be not empty")
        @JsonDeserialize(using = GenderDeserializer.class)
        Gender gender,

        @NotBlank(message = "The 'countryOfResidence' field must be not empty")
        @Size(max = 32, message = "The size of the 'countryOfResidence' field must not exceed 32 characters")
        String countryOfResidence,

        @NotBlank(message = "The 'regionOfResidence' field must be not empty")
        @Size(max = 32, message = "The size of the 'regionOfResidence' field must not exceed 32 characters")
        String regionOfResidence,

        @NotBlank(message = "The 'contacts' field must be not empty")
        String contacts) {
}
