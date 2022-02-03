package com.github.viiiraj07;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {

    ContactManager contactManager;

    @BeforeAll
    void beforeAll() {
        /*We don't need to mark it as static because we have changed the default test lifecycle
        by using @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        */
        contactManager = new ContactManager();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Before each test cases");
    }

    @AfterAll
    void afterAll() {
        System.out.println("After all test cases");
    }

    @Test
    @DisplayName("Should Throw Exception when null is passed")
    void addContact() {
        Assertions.assertThrows(Exception.class, () -> {
            contactManager.addContact("ABhishek", "Kumar", null);
        });
    }

    @Test
    @DisplayName("Check if contact list is empty")
    void checkList() {
        Assertions.assertTrue(contactManager.contactList.isEmpty());
    }

    @Test
    @DisplayName("Throw exception for invalid phone number")
    void validatePhoneNumber() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Contact contact = new Contact("Abbb", "Kkk", "3535fafs2asf525");
            contact.validatePhoneNumber();
        });
    }

    @RepeatedTest(value = 10)
    void loopingTest() {
        System.out.println("This will be printed multiple times");
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class PhoneNumberTest {
        @Disabled
        @ParameterizedTest
        @CsvSource({"4172417294", "0124124124", "12412412"})
        void checkNumbers(String phoneNumber) {
            Assertions.assertThrows(RuntimeException.class, () -> {
                Contact contact = new Contact("Abbb", "Kkk", phoneNumber);
                contact.validatePhoneNumber();
            });
        }

        @DisplayName("Check Numbers Using MethodSource")
        @ParameterizedTest
        @MethodSource("listOfPhoneNumbers")
        void checkNumbersUsingMethodSource(String phoneNumber) {
            Assertions.assertThrows(RuntimeException.class, () -> {
                Contact contact = new Contact("Abbb", "Kkk", phoneNumber);
                contact.validatePhoneNumber();
            });
        }

        String[] listOfPhoneNumbers() {
            return new String[]{"4172417294", "124124124", "12412412"};
        }

    }
}