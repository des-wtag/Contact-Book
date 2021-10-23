package com.ContactBook.service;

import com.ContactBook.dto.ContactDto;
import com.ContactBook.model.Contact;
import com.ContactBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;


    // Injected user repository interface

    public ContactServiceImpl(ContactRepository contactRepository) {
        super();
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact save(ContactDto contactDto) {

        Contact contact = new Contact(contactDto.getFirstName(),
                contactDto.getLastName(),
                contactDto.getEmail(),
                contactDto.getPhoneNumber(),
                contactDto.getNote());

        return contactRepository.save(contact);

    }

    public List<Contact> listAllContact() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContact(Long id) {
        Optional<Contact> contact = contactRepository.findById(id);
        return contact;
    }
}
