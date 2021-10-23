package com.ContactBook.dto;

import com.ContactBook.model.Contact;
import com.ContactBook.model.Role;

import java.util.Collection;

public class UserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Collection<Contact> contacts;
    private Collection<Role> roles;

    public UserDto(){

    }

    public UserDto(String firstName, String lastName, String email, String password, Collection<Role> roles, Collection<Contact> contacts) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.contacts = contacts;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Collection<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(Collection<Contact> contacts) {
        this.contacts = contacts;
    }
    public Collection<Role> getRoles() {
    return roles;
    }
    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
