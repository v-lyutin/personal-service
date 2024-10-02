package com.dev.internal.personal.mail.web.dto.response;

import java.util.UUID;

public record CorporateMailResponse(
        UUID id,
        String address,
        UUID employeeId) {
}
