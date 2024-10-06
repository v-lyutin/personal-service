package com.dev.internal.personal.employee.mapper.impl;

import com.dev.internal.common.mapper.JsonNullableMapper;
import com.dev.internal.personal.employee.mapper.EmployeeMapper;
import com.dev.internal.personal.employee.model.Employee;
import com.dev.internal.personal.employee.model.dto.request.EmployeeCreateRequest;
import com.dev.internal.personal.employee.model.dto.request.EmployeeUpdateRequest;
import com.dev.internal.personal.employee.model.dto.response.EmployeeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeMapperImpl implements EmployeeMapper {
    private final JsonNullableMapper jsonNullableMapper;

    @Override
    public Employee toEmployee(EmployeeCreateRequest request) {
        return Employee.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .middleName(request.middleName())
                .dateOfBirth(request.dateOfBirth())
                .gender(request.gender())
                .countryOfResidence(request.countryOfResidence())
                .regionOfResidence(request.regionOfResidence())
                .contacts(request.contacts())
                .isDismissed(false)
                .build();
    }

    @Override
    public EmployeeResponse toEmployeeResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getMiddleName(),
                employee.getDateOfBirth(),
                employee.getGender(),
                employee.getCountryOfResidence(),
                employee.getRegionOfResidence(),
                employee.getContacts(),
                employee.getIsDismissed(),
                employee.getDateOfDismissal()
        );
    }

    @Override
    public Employee patch(Employee employee, EmployeeUpdateRequest request) {
        if (request != null) {
            if (jsonNullableMapper.isPresent(request.firstName())) {
                employee.setFirstName(jsonNullableMapper.unwrap(request.firstName()));
            }
            if (jsonNullableMapper.isPresent(request.lastName())) {
                employee.setLastName(jsonNullableMapper.unwrap(request.lastName()));
            }
            if (jsonNullableMapper.isPresent(request.middleName())) {
                employee.setMiddleName(jsonNullableMapper.unwrap(request.middleName()));
            }
            if (jsonNullableMapper.isPresent(request.dateOfBirth())) {
                employee.setDateOfBirth(jsonNullableMapper.unwrap(request.dateOfBirth()));
            }
            if (jsonNullableMapper.isPresent(request.gender())) {
                employee.setGender(jsonNullableMapper.unwrap(request.gender()));
            }
            if (jsonNullableMapper.isPresent(request.countryOfResidence())) {
                employee.setCountryOfResidence(jsonNullableMapper.unwrap(request.countryOfResidence()));
            }
            if (jsonNullableMapper.isPresent(request.regionOfResidence())) {
                employee.setRegionOfResidence(jsonNullableMapper.unwrap(request.regionOfResidence()));
            }
        }
        return employee;
    }
}
