package com.dev.internal.personal.mail.repository;

import com.dev.internal.personal.mail.model.CorporateMail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CorporateMailRepository extends JpaRepository<CorporateMail, UUID> {
    Optional<CorporateMail> findByAddress(String address);
}
