package com.github.viiiraj07;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    void beforeAll(){
        /*We don't need to mark it as static because we have changed the default test lifecycle
        by using @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        */
        contactManager = new ContactManager();
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("Before each test cases");
    }

    @AfterAll
    void afterAll(){
        System.out.println("After all test cases");
    }

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