package com.dev.internal.personal.employee.usecase;

import com.dev.internal.personal.employee.model.dto.request.EmployeeCreateRequest;
import com.dev.internal.personal.employee.model.dto.request.EmployeeUpdateRequest;
import com.dev.internal.personal.employee.model.dto.response.EmployeeResponse;

import java.util.UUID;

public interface EmployeeUseCase {
    EmployeeResponse createEmployee(EmployeeCreateRequest request);

    EmployeeResponse patchEmployee(UUID employeeId, EmployeeUpdateRequest request);

    EmployeeResponse dismissEmployee(UUID employeeId);

    EmployeeResponse getEmployeeById(UUID employeeId);
}
