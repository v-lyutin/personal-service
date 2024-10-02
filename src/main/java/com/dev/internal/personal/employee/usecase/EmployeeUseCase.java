package com.dev.internal.personal.employee.usecase;

import com.dev.internal.personal.employee.web.dto.request.EmployeeCreateRequest;
import com.dev.internal.personal.employee.web.dto.request.EmployeeUpdateRequest;
import com.dev.internal.personal.employee.web.dto.response.EmployeeResponse;

import java.util.UUID;

public interface EmployeeUseCase {
    EmployeeResponse createEmployee(EmployeeCreateRequest request);

    EmployeeResponse patchEmployee(UUID employeeId, EmployeeUpdateRequest request);

    EmployeeResponse dismissEmployee(UUID employeeId);

    EmployeeResponse getEmployee(UUID employeeId);
}
