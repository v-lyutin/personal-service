package com.dev.internal.personal.department.mapper;

import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.department.model.dto.request.DepartmentCreateRequest;
import com.dev.internal.personal.department.model.dto.request.DepartmentUpdateRequest;
import com.dev.internal.personal.department.model.dto.response.DepartmentResponse;

public interface DepartmentMapper {
    Department toDepartment(DepartmentCreateRequest request);

    DepartmentResponse toDepartmentResponse(Department department);

    Department patch(Department department, DepartmentUpdateRequest request);
}
