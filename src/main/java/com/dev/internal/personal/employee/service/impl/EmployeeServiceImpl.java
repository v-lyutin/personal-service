package com.dev.internal.personal.employee.service.impl;

import com.dev.internal.common.exception.ServiceException;
import com.dev.internal.personal.employee.service.EmployeeService;
import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee dismissEmployeeById(UUID employeeId) {
        Employee employee = getEmployeeById(employeeId);
        employee.setIsDismissed(true);
        employee.setDateOfDismissal(LocalDate.now());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(UUID employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Employee with ID '%s' not found.", employeeId)
                ));
    }
}
