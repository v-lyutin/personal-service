package com.dev.internal.personal.employee.web;

import com.dev.internal.personal.employee.usecase.EmployeeUseCase;
import com.dev.internal.personal.employee.model.dto.request.EmployeeCreateRequest;
import com.dev.internal.personal.employee.model.dto.request.EmployeeUpdateRequest;
import com.dev.internal.personal.employee.model.dto.response.EmployeeResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/staff")
public class EmployeeController {
    private final EmployeeUseCase employeeUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeCreateRequest request) {
        return employeeUseCase.createEmployee(request);
    }

    @GetMapping(value = "{employeeId}")
    public EmployeeResponse getEmployeeById(@PathVariable(name = "employeeId") UUID employeeId) {
        return employeeUseCase.getEmployeeById(employeeId);
    }

    @PatchMapping(value = "{employeeId}")
    public EmployeeResponse patchEmployee(@PathVariable(name = "employeeId") UUID employeeId,
                                          @Valid @RequestBody EmployeeUpdateRequest request) {
        return employeeUseCase.patchEmployee(employeeId, request);
    }

    @PutMapping(value = "{employeeId}")
    public EmployeeResponse dismissEmployee(@PathVariable(name = "employeeId") UUID employeeId) {
        return employeeUseCase.dismissEmployee(employeeId);
    }
}
