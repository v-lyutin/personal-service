package com.dev.internal.personal.department.service;

import com.dev.internal.personal.department.model.Department;

import java.util.Set;
import java.util.UUID;

public interface DepartmentService {
    Department createDepartment(Department department);

    Department updateDepartment(Department department);

    Department getDepartmentById(UUID departmentId);

    Set<Department> getAllDepartments();

    Department archiveDepartment(Department department);

    void deleteDepartmentById(UUID departmentId);
}
