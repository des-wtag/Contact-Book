package com.ContactBook.service;

import com.ContactBook.dto.ContactDto;
import com.ContactBook.model.Contact;

public interface ContactService {
    Contact save(ContactDto contact);
}