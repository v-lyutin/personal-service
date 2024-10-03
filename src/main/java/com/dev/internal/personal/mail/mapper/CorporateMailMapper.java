package com.dev.internal.personal.mail.mapper;

import com.dev.internal.personal.mail.model.CorporateMail;
import com.dev.internal.personal.mail.model.dto.request.CorporateMailCreateRequest;
import com.dev.internal.personal.mail.model.dto.response.CorporateMailResponse;
import com.dev.internal.personal.employee.model.Employee;

public interface CorporateMailMapper {
    CorporateMail toCorporateMail(Employee employee, CorporateMailCreateRequest request);
    CorporateMailResponse toCorporateMailResponse(CorporateMail corporateMail);
}
