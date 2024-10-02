package com.dev.internal.personal.employee.usecase.impl;

import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.employee.service.EmployeeService;
import com.dev.internal.personal.employee.usecase.EmployeeUseCase;
import com.dev.internal.personal.employee.web.dto.request.EmployeeCreateRequest;
import com.dev.internal.personal.employee.web.dto.request.EmployeeUpdateRequest;
import com.dev.internal.personal.employee.web.dto.response.EmployeeResponse;
import com.dev.internal.personal.employee.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmployeeUseCaseFacade implements EmployeeUseCase {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeResponse createEmployee(EmployeeCreateRequest request) {
        Employee employee = employeeMapper.toEmployee(request);
        return employeeMapper.toEmployeeResponse(employeeService.createEmployee(employee));
    }

    @Override
    public EmployeeResponse patchEmployee(UUID employeeId, EmployeeUpdateRequest request) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        employee = employeeMapper.patch(employee, request);
        return employeeMapper.toEmployeeResponse(employeeService.updateEmployee(employee));
    }

    @Override
    public EmployeeResponse dismissEmployee(UUID employeeId) {
        return employeeMapper.toEmployeeResponse(employeeService.dismissEmployeeById(employeeId));
    }

    @Override
    public EmployeeResponse getEmployee(UUID employeeId) {
        return employeeMapper.toEmployeeResponse(employeeService.getEmployeeById(employeeId));
    }
}
