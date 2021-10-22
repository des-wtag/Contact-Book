package com.ContactBook.repository;

import com.ContactBook.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{
    Contact findByEmail(String email);

    Contact findById(Integer id);

    List<Contact> findByFirstName(String firstName);
    List<Contact> findByUserId(Integer userId);
}
