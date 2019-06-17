package com.codecool.filepnora.ecoself.repository;

import com.codecool.filepnora.ecoself.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
