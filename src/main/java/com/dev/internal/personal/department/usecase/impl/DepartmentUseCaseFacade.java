package com.dev.internal.personal.department.usecase.impl;

import com.dev.internal.personal.department.mapper.DepartmentMapper;
import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.department.model.dto.request.DepartmentCreateRequest;
import com.dev.internal.personal.department.model.dto.request.DepartmentUpdateRequest;
import com.dev.internal.personal.department.model.dto.response.DepartmentResponse;
import com.dev.internal.personal.department.service.DepartmentService;
import com.dev.internal.personal.department.usecase.DepartmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DepartmentUseCaseFacade implements DepartmentUseCase {
    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {
        Department department = departmentMapper.toDepartment(request);
        return departmentMapper.toDepartmentResponse(departmentService.createDepartment(department));
    }

    @Override
    public DepartmentResponse patchDepartment(UUID departmentId, DepartmentUpdateRequest request) {
        Department department = departmentService.getDepartmentById(departmentId);
        department = departmentMapper.patch(department, request);
        return departmentMapper.toDepartmentResponse(departmentService.updateDepartment(department));
    }

    @Override
    public DepartmentResponse getDepartmentById(UUID departmentId) {
        return departmentMapper.toDepartmentResponse(departmentService.getDepartmentById(departmentId));
    }

    @Override
    public Set<DepartmentResponse> getAllDepartments() {
        return departmentService.getAllDepartments().stream()
                .map(departmentMapper::toDepartmentResponse)
                .collect(Collectors.toSet());
    }

    @Override
    public DepartmentResponse archiveDepartment(UUID departmentId) {
        Department department = departmentService.getDepartmentById(departmentId);
        return departmentMapper.toDepartmentResponse(departmentService.archiveDepartment(department));
    }

    @Override
    public void deleteDepartmentById(UUID departmentId) {
        departmentService.deleteDepartmentById(departmentId);
    }
}
