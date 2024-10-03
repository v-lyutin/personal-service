package com.dev.internal.personal.employee.mapper;

import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.employee.model.dto.request.EmployeeCreateRequest;
import com.dev.internal.personal.employee.model.dto.request.EmployeeUpdateRequest;
import com.dev.internal.personal.employee.model.dto.response.EmployeeResponse;

public interface EmployeeMapper {
    Employee toEmployee(EmployeeCreateRequest request);

    EmployeeResponse toEmployeeResponse(Employee employee);

    Employee patch(Employee employee, EmployeeUpdateRequest request);
}
