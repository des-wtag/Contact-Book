package com.ContactBook.controller.API;


import com.ContactBook.model.Contact;
import com.ContactBook.repository.ContactRepository;
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
    private ContactRepository contactRepository;

    @GetMapping("contact/{id}")
    public ResponseEntity<Contact> get(@PathVariable Long id) {
        try {
            Contact contact = contactRepository.findById(id).get();
            return new ResponseEntity<Contact>(contact, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Contact>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> get() {
        try {
            List<Contact> contacts = new ArrayList<Contact>();
            contactRepository.findAll().forEach(contacts::add);
            return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<List<Contact>>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createContact")
    public ResponseEntity<Contact> CreateContact(@RequestBody Contact contact) {
        try {
            Contact _contact = contactRepository
                    .save(new Contact(contact.getFirstName(), contact.getLastName(), contact.getEmail(), contact.getNote(), contact.getPhoneNumber()));
            return new ResponseEntity<Contact>(_contact, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/contact/add")
//    public Contact addContact(@RequestBody Contact contact) {
//            return contactService.save(contact);
//    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable("id") long id) {
        try {
            contactRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}