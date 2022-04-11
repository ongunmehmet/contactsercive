package com.example.demirorenapp.service;

import com.example.demirorenapp.dto.ContactDto;
import com.example.demirorenapp.entity.ContactId;
import com.example.demirorenapp.entity.Contacts;
import com.example.demirorenapp.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class StandarContactService implements ContactService{
    private ContactRepository contactRepository;
    private ModelMapper modelMapper;

    public StandarContactService(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Contacts> add(ContactDto [] contacts) {

        List<ContactDto> contactss= Arrays.stream(contacts).toList();
        List<Contacts> contactsArrayList=contactss.stream().map(a->modelMapper.map(a,Contacts.class)).toList();

        for(int i=0;i<contactsArrayList.size()-1;i++){

            if((contactRepository.findById(contactsArrayList.get(i).getContactId())).isPresent()) {

                Contacts updatedContact = contactRepository.findById(contactsArrayList.get(i).getContactId()).orElseThrow(()->new IllegalArgumentException() );
                List<String> updatedPhones = updatedContact.getPhones();

                var contactDifference = contactsArrayList.get(i).getPhones().stream().filter(telNum -> !(updatedContact.getPhones()).contains(telNum)).collect(Collectors.toList());
                contactDifference.stream().forEach(num -> updatedPhones.add(num));
                updatedContact.setPhones(updatedPhones);
                contactRepository.save(updatedContact);

                List<Contacts> updatedList = List.of(contactRepository.getById(contactsArrayList.get(i).getContactId()));


            } else {contactRepository.save(contactsArrayList.get(i));}



        }

        return contactsArrayList;


    }

    @Override
    public Contacts getContact(String name, String lastName) {
       ContactId contactId=new ContactId(name,lastName);
       return contactRepository.findById(contactId).orElseThrow(()-> new IllegalArgumentException("Contact do not exist"));

    }
}
