package com.tirth.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LibraryTest {

    static Library library;
    @BeforeAll
    static void init() {
        library = new Library(
                "Tirth's Library",
                "3/Alien Street, Behind Satellite Showroom, Moon, Earth, Solar System",
                "no-reply@tirthlibrary.com",
                "tirth132",
                "something");
    }

    // Test all getters in Library class
    @Test
    @DisplayName("Test getters")
    void testGetters() {
        assertEquals("Tirth's Library", library.getName());
        assertEquals(
                "3/Alien Street, Behind Satellite Showroom, Moon, Earth, Solar System",
                library.getAddress());
        assertEquals("no-reply@tirthlibrary.com", library.getEmail());
        assertEquals("tirth132", library.getAdmin());
    }

    // Test password checker
    @Test
    @DisplayName("Test password checker")
    void testPasswordChecker() {
        assertTrue(library.checkPassword("something"));
    }
}
