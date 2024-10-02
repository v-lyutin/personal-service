package com.dev.internal.personal.mail.service.impl;

import com.dev.internal.common.exception.ServiceException;
import com.dev.internal.personal.mail.repository.CorporateMailRepository;
import com.dev.internal.personal.mail.service.CorporateMailService;
import com.dev.internal.personal.mail.model.CorporateMail;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CorporateMailServiceImpl implements CorporateMailService {
    private final CorporateMailRepository corporateMailRepository;

    @Override
    public CorporateMail createCorporateMail(CorporateMail corporateMail) {
        checkAddress(corporateMail);
        return corporateMailRepository.save(corporateMail);
    }

    @Override
    public CorporateMail updateCorporateMail(CorporateMail corporateMail) {
        checkAddress(corporateMail);
        return corporateMailRepository.save(corporateMail);
    }

    @Override
    public CorporateMail getCorporateMailById(UUID corporateMailId) {
        return corporateMailRepository.findById(corporateMailId)
                .orElseThrow(() -> new ServiceException(
                        HttpStatus.NOT_FOUND,
                        String.format("Corporate mail with ID '%s' not found.", corporateMailId)
                ));
    }

    @Override
    public void deleteCorporateMailById(UUID corporateMailId) {
        corporateMailRepository.deleteById(corporateMailId);
    }

    private void checkAddress(CorporateMail corporateMail) {
        if (corporateMailRepository.findByAddress(corporateMail.getAddress()).isPresent()) {
            throw new ServiceException(
                    HttpStatus.BAD_REQUEST,
                    String.format("Address '%s' already exists.", corporateMail.getAddress())
            );
        }
    }
}
