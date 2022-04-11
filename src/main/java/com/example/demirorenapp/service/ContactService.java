package com.example.demirorenapp.service;

import com.example.demirorenapp.dto.ContactDto;
import com.example.demirorenapp.entity.Contacts;

import java.util.List;

public interface ContactService {
    List<Contacts> add(ContactDto [] contacts);



    Contacts getContact(String name,String lastName);


}
