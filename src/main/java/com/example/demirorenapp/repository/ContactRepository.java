package com.example.demirorenapp.repository;

import com.example.demirorenapp.entity.ContactId;
import com.example.demirorenapp.entity.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactRepository extends JpaRepository<Contacts, ContactId>{
    @Override
    Contacts getById(ContactId contactId);
}
