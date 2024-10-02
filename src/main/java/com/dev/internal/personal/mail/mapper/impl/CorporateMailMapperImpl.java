package com.dev.internal.personal.mail.mapper.impl;

import com.dev.internal.personal.mail.mapper.CorporateMailMapper;
import com.dev.internal.personal.mail.model.CorporateMail;
import com.dev.internal.personal.mail.web.dto.request.CorporateMailCreateRequest;
import com.dev.internal.personal.mail.web.dto.response.CorporateMailResponse;
import com.dev.internal.personal.employee.model.Employee;
import org.springframework.stereotype.Component;


@Component
public class CorporateMailMapperImpl implements CorporateMailMapper {
    @Override
    public CorporateMail toCorporateMail(Employee employee, CorporateMailCreateRequest request) {
        return CorporateMail.builder()
                .address(request.address())
                .employee(employee)
                .build();
    }

    @Override
    public CorporateMailResponse toCorporateMailResponse(CorporateMail corporateMail) {
        return new CorporateMailResponse(
                corporateMail.getId(),
                corporateMail.getAddress(),
                corporateMail.getEmployee().getId()
        );
    }
}
