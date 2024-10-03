package com.dev.internal.personal.employee.model.dto.response;

import com.dev.internal.personal.employee.model.enums.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.UUID;

public record EmployeeResponse(
        UUID id,

        String firstName,

        String lastName,

        String middleName,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateOfBirth,

        Gender gender,

        String countryOfResidence,

        String regionOfResidence,

        String contacts,

        boolean isDismissed,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate dateOfDismissal) {
}
