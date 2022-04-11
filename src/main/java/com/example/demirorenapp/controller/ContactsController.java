package com.example.demirorenapp.controller;

import com.example.demirorenapp.dto.ContactDto;
import com.example.demirorenapp.entity.Contacts;
import com.example.demirorenapp.service.ContactService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactsController {
    private ContactService contactService;


    public ContactsController(ContactService contactService) {
        this.contactService = contactService;

    }


    @PostMapping(value = "/add",consumes = "application/json" ,produces ="application/json" )
    public List<Contacts> add(@RequestBody ContactDto [] contacts){
        return contactService.add(contacts);
    }

    @GetMapping("/get")
    public ResponseEntity<Contacts> get(@RequestParam String name,@RequestParam String lastName){
        return ResponseEntity.ok(contactService.getContact(name,lastName));
    }



}
