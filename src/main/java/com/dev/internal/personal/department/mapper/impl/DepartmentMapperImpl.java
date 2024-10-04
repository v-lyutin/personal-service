package com.dev.internal.personal.department.mapper.impl;

import com.dev.internal.common.mapper.JsonNullableMapper;
import com.dev.internal.personal.department.mapper.DepartmentMapper;
import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.department.model.dto.request.DepartmentCreateRequest;
import com.dev.internal.personal.department.model.dto.request.DepartmentUpdateRequest;
import com.dev.internal.personal.department.model.dto.response.DepartmentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentMapperImpl implements DepartmentMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Department toDepartment(DepartmentCreateRequest request) {
        return Department.builder()
                .displayName(request.displayName())
                .description(request.description())
                .isActive(true)
                .build();
    }

    @Override
    public DepartmentResponse toDepartmentResponse(Department department) {
        return new DepartmentResponse(
                department.getId(),
                department.getDisplayName(),
                department.getDescription(),
                department.isActive()
        );
    }

    @Override
    public Department patch(Department department, DepartmentUpdateRequest request) {
        if (request != null) {
            if (jsonNullableMapper.isPresent(request.displayName())) {
                department.setDisplayName(jsonNullableMapper.unwrap(request.displayName()));
            }
            if (jsonNullableMapper.isPresent(request.description())) {
                department.setDescription(jsonNullableMapper.unwrap(request.description()));
            }
        }
        return department;
    }
}
