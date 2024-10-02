package com.dev.internal.personal.employee.service;

import com.dev.internal.personal.employee.model.Employee;

import java.util.UUID;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    Employee dismissEmployeeById(UUID employeeId);

    Employee getEmployeeById(UUID employeeId);
}
