package com.ContactBook.service;

import com.ContactBook.model.Contact;
import com.ContactBook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;
    public List<Contact> listAllContact() {
        return contactRepository.findAll();
    }

    public void saveContact(Contact contact) {
        contactRepository.save(contact);
    }

    public Contact getContact(Long id) {
        Contact contact = contactRepository.findById(id);
        return contact;
    }
}