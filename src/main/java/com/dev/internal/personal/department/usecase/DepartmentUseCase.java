package com.dev.internal.personal.department.usecase;

import com.dev.internal.personal.department.model.dto.request.DepartmentCreateRequest;
import com.dev.internal.personal.department.model.dto.request.DepartmentUpdateRequest;
import com.dev.internal.personal.department.model.dto.response.DepartmentResponse;

import java.util.Set;
import java.util.UUID;

public interface DepartmentUseCase {
    DepartmentResponse createDepartment(DepartmentCreateRequest request);

    DepartmentResponse patchDepartment(UUID departmentId, DepartmentUpdateRequest request);

    DepartmentResponse getDepartmentById(UUID departmentId);

    Set<DepartmentResponse> getAllDepartments();

    DepartmentResponse archiveDepartment(UUID departmentId);

    void deleteDepartmentById(UUID departmentId);
}
