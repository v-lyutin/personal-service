package com.dev.internal.personal.department.web;

import com.dev.internal.personal.department.model.dto.request.DepartmentCreateRequest;
import com.dev.internal.personal.department.model.dto.request.DepartmentUpdateRequest;
import com.dev.internal.personal.department.model.dto.response.DepartmentResponse;
import com.dev.internal.personal.department.usecase.DepartmentUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {
    private final DepartmentUseCase departmentUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartmentResponse createDepartment(@Valid @RequestBody DepartmentCreateRequest request) {
        return departmentUseCase.createDepartment(request);
    }

    @PatchMapping(value = "{departmentId}")
    public DepartmentResponse patchDepartment(@PathVariable(name = "departmentId") UUID departmentId,
                                              @Valid @RequestBody DepartmentUpdateRequest request) {
        return departmentUseCase.patchDepartment(departmentId, request);
    }

    @GetMapping(value = "{departmentId}")
    public DepartmentResponse getDepartmentById(@PathVariable(name = "departmentId") UUID departmentId) {
        return departmentUseCase.getDepartmentById(departmentId);
    }

    @GetMapping
    public Set<DepartmentResponse> getAllDepartments() {
        return departmentUseCase.getAllDepartments();
    }

    @PutMapping(value = "{departmentId}")
    public DepartmentResponse archiveDepartment(@PathVariable(name = "departmentId") UUID departmentId) {
        return departmentUseCase.archiveDepartment(departmentId);
    }

    @DeleteMapping(value = "{departmentId}")
    public void deleteDepartmentById(@PathVariable(name = "departmentId") UUID departmentId) {
        departmentUseCase.deleteDepartmentById(departmentId);
    }
}
