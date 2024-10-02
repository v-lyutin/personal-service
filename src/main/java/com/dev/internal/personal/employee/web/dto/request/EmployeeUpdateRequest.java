package com.dev.internal.personal.employee.web.dto.request;

import com.dev.internal.personal.employee.model.enums.Gender;
import com.dev.internal.personal.employee.util.GenderDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.openapitools.jackson.nullable.JsonNullable;

import java.time.LocalDate;

public record EmployeeUpdateRequest(
        @Size(max = 32, message = "The size of the 'firstName' field must not exceed 32 characters")
        JsonNullable<String> firstName,

        @Size(max = 32, message = "The size of the 'lastName' field must not exceed 32 characters")
        JsonNullable<String> lastName,

        @Size(max = 32, message = "The size of the 'middleName' field must not exceed 32 characters")
        JsonNullable<String> middleName,

        @PastOrPresent(message = "Date of birth from the future")
        @JsonFormat(pattern = "yyyy-MM-dd")
        JsonNullable<LocalDate> dateOfBirth,

        @JsonDeserialize(using = GenderDeserializer.class)
        JsonNullable<Gender> gender,

        @Size(max = 32, message = "The size of the 'countryOfResidence' field must not exceed 32 characters")
        JsonNullable<String> countryOfResidence,

        @Size(max = 32, message = "The size of the 'regionOfResidence' field must not exceed 32 characters")
        JsonNullable<String> regionOfResidence) {
}