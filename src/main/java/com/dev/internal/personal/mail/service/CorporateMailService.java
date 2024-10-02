package com.dev.internal.personal.mail.service;

import com.dev.internal.personal.mail.model.CorporateMail;

import java.util.UUID;

public interface CorporateMailService {
    CorporateMail createCorporateMail(CorporateMail corporateMail);

    CorporateMail updateCorporateMail(CorporateMail corporateMail);

    CorporateMail getCorporateMailById(UUID corporateMailId);

    void deleteCorporateMailById(UUID corporateMailId);
}
