package com.dev.internal.personal.mail.web;

import com.dev.internal.personal.mail.usecase.CorporateMailUseCase;
import com.dev.internal.personal.mail.model.dto.request.CorporateMailCreateRequest;
import com.dev.internal.personal.mail.model.dto.request.CorporateMailUpdateRequest;
import com.dev.internal.personal.mail.model.dto.response.CorporateMailResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/staff")
public class CorporateMailController {
    private final CorporateMailUseCase corporateMailUseCase;

    @PostMapping(value = "{employeeId}/corporate-mails")
    @ResponseStatus(HttpStatus.CREATED)
    public Set<CorporateMailResponse> addCorporateMailsToEmployee(@PathVariable(name = "employeeId") UUID employeeId,
                                                                  @Valid @RequestBody Set<CorporateMailCreateRequest> request) {
        return corporateMailUseCase.addCorporateMailsToEmployee(employeeId, request);
    }

    @GetMapping(value = "{employeeId}/corporate-mails")
    public Set<CorporateMailResponse> getCorporateMailsByEmployee(@PathVariable(name = "employeeId") UUID employeeId) {
        return corporateMailUseCase.getCorporateMailsByEmployee(employeeId);
    }

    @PutMapping(value = "corporate-mails/{corporateMailId}")
    public CorporateMailResponse updateCorporateMail(@PathVariable(name = "corporateMailId") UUID corporateMailId,
                                                     @Valid @RequestBody CorporateMailUpdateRequest request) {
        return corporateMailUseCase.updateCorporateMail(corporateMailId, request);
    }

    @DeleteMapping(value = "corporate-mails/{corporateMailId}")
    public void deleteCorporateMail(@PathVariable(name = "corporateMailId") UUID corporateMailId) {
        corporateMailUseCase.deleteCorporateMail(corporateMailId);
    }
}
