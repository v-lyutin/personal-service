package com.dev.internal.personal.department.service.impl;

import com.dev.internal.common.exception.ServiceException;
import com.dev.internal.personal.department.model.Department;
import com.dev.internal.personal.department.repository.DepartmentRepository;
import com.dev.internal.personal.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(UUID departmentId) {
        return departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Department with ID '%s' not found.", departmentId)
                ));
    }

    @Override
    public Set<Department> getAllDepartments() {
        return new HashSet<>(departmentRepository.findAll());
    }

    @Override
    public Department archiveDepartment(Department department) {
        department.setActive(false);
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartmentById(UUID departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
