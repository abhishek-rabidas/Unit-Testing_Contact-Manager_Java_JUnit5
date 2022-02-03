package com.github.viiiraj07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

    ContactManager contactManager = new ContactManager();

    @Test
    @DisplayName("Should Throw Exception when null is passed")
    void addContact() {
        Assertions.assertThrows(Exception.class, ()->{
            contactManager.addContact("ABhishek", "Kumar", null);
        });
    }

    @Test
    @DisplayName("Check if contact list is empty")
    void checkList(){
        Assertions.assertTrue(contactManager.contactList.isEmpty());
    }

    @Test
    @DisplayName("Throw exception for invalid phone number")
    void validatePhoneNumber(){
        Assertions.assertThrows(RuntimeException.class, ()->{
            Contact contact = new Contact("Abbb", "Kkk", "3535fafs2asf525");
            contact.validatePhoneNumber();
        });
    }
}