package com.dev.internal.personal.mail.usecase;

import com.dev.internal.personal.mail.web.dto.request.CorporateMailCreateRequest;
import com.dev.internal.personal.mail.web.dto.request.CorporateMailUpdateRequest;
import com.dev.internal.personal.mail.web.dto.response.CorporateMailResponse;

import java.util.Set;
import java.util.UUID;

public interface CorporateMailUseCase {
    Set<CorporateMailResponse> addCorporateMailsToEmployee(UUID employeeId, Set<CorporateMailCreateRequest> request);

    CorporateMailResponse updateCorporateMail(UUID corporateMailId, CorporateMailUpdateRequest request);

    void deleteCorporateMail(UUID corporateMailId);

    Set<CorporateMailResponse> getCorporateMailsByEmployee(UUID employeeId);
}
