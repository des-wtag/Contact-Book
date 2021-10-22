package com.ContactBook.controller;


import com.ContactBook.model.Contact;
import com.ContactBook.repository.ContactRepository;
import com.ContactBook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    ContactRepository contactRepository;
    ContactService contactService;

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts(@RequestParam(required = false) String firstName) {
        try {
            List<Contact> contacts = new ArrayList<Contact>();

            if (firstName == null)
                contactRepository.findAll().forEach(contacts::add);
            else
                contactRepository.findByFirstName(firstName).forEach(contacts::add);

            if (contacts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("contact/{id}")
    public ResponseEntity<Contact> get(@PathVariable Long id) {
        try {
            Contact contact = contactService.getContact(id);
            return new ResponseEntity<Contact>(contact, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        try {
            Contact _contact = contactRepository
                    .save(new Contact(contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getNote(), contact.getPhoneNumber()));
            return new ResponseEntity<>(_contact, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}