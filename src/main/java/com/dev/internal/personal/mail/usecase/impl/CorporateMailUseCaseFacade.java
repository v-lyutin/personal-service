package com.dev.internal.personal.mail.usecase.impl;

import com.dev.internal.personal.employee.service.EmployeeService;
import com.dev.internal.personal.mail.usecase.CorporateMailUseCase;
import com.dev.internal.personal.mail.model.dto.request.CorporateMailUpdateRequest;
import com.dev.internal.personal.mail.mapper.CorporateMailMapper;
import com.dev.internal.personal.mail.model.CorporateMail;
import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.mail.service.CorporateMailService;
import com.dev.internal.personal.mail.model.dto.request.CorporateMailCreateRequest;
import com.dev.internal.personal.mail.model.dto.response.CorporateMailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CorporateMailUseCaseFacade implements CorporateMailUseCase {
    private final CorporateMailService corporateMailService;
    private final CorporateMailMapper corporateMailMapper;
    private final EmployeeService employeeService;

    @Override
    public Set<CorporateMailResponse> addCorporateMailsToEmployee(UUID employeeId, Set<CorporateMailCreateRequest> request) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        Set<CorporateMail> corporateMails = request.stream()
                .map(mailData -> corporateMailMapper.toCorporateMail(employee, mailData))
                .collect(Collectors.toSet());
        return corporateMails.stream()
                .map(corporateMailService::createCorporateMail)
                .map(corporateMailMapper::toCorporateMailResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public CorporateMailResponse updateCorporateMail(UUID corporateMailId, CorporateMailUpdateRequest request) {
        CorporateMail corporateMail = corporateMailService.getCorporateMailById(corporateMailId);
        corporateMail.setAddress(request.address());
        return corporateMailMapper.toCorporateMailResponse(corporateMailService.updateCorporateMail(corporateMail));
    }

    @Override
    public void deleteCorporateMailById(UUID corporateMailId) {
        corporateMailService.deleteCorporateMailById(corporateMailId);
    }

    @Override
    public Set<CorporateMailResponse> getCorporateMailsByEmployee(UUID employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee.getCorporateMails().stream()
                .map(corporateMailMapper::toCorporateMailResponse)
                .collect(Collectors.toSet());
    }
}
