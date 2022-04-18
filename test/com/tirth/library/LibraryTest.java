package com.tirth.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Test book search")
    void testBookSearch() {
        assertEquals(
                "Tirth Patel",
                library.searchBook("Library Management System").getAuthor());
    }

    @Test
    @DisplayName("Test add book copies")
    void testAddBookCopies() {
        int copiesExisting = library.searchBook("Library Management System").getQuantity();
        library.addBookCopies("Library Management System", 5);

        assertEquals(copiesExisting + 5,
                library.searchBook("Library Management System").getQuantity());
    }

    @Test
    @DisplayName("Test add new book function")
    void testAddNewBook() {
        Book libBook = new Book(
                "Library Management System",
                "Tirth Patel",
                0,
                3);
        int existingCopies = library.searchBook("Library Management System").getQuantity();
        library.addNewBook(libBook);

        assertEquals(existingCopies + 3,
                library.searchBook("Library Management System").getQuantity());

        Book physicsForBeginners = new Book("Physics For Beginners",
                "Tirth Patel",
                14.5f,
                20);
        library.addNewBook(physicsForBeginners);
        assertNotNull(library.searchBook("Physics For Beginners"), "New book not added");
    }

    @Test
    @DisplayName("Test remove book copies function")
    void testRemoveBookCopies() {
        String bookName = "Library Management System";
        Book book = library.searchBook(bookName);

        int existingCopies = book.getQuantity();
        if (existingCopies == 0) {
            library.addBookCopies(bookName, 5);
        }
        library.removeBookCopies(bookName, 1);

        assertEquals(existingCopies - 1,
                library.searchBook(bookName).getQuantity());
    }
}
