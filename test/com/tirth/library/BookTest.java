package com.tirth.library;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookTest {

    static Book book;
    @BeforeAll
    static void setBook() {
        book = new Book("Java", "Tirth", 14.5f, 1);
    }

    @Test
    @DisplayName("Test for getter for Book class")
    void testGetters() {
        assertEquals("Java", book.getTitle());
        assertEquals("Tirth", book.getAuthor());
        assertEquals(14.5f, book.getPrice());
    }

    @Test
    @DisplayName("Test for addCopies method")
    void testAddCopies() {
        int copies = book.getQuantity();
        int copiesToAdd = (int) (Math.random() * 10);

        book.addCopies(copiesToAdd);
        assertEquals(copies + copiesToAdd, book.getQuantity());
    }

    @Test
    @DisplayName("Test for removeCopies method")
    void testRemoveCopies() {
        int copies = book.getQuantity();
        int copiesToRemove = (int) (Math.random() * (copies - 1));

        book.removeCopies(copiesToRemove);
        assertEquals(copies - copiesToRemove, book.getQuantity());
    }

    @Test
    @DisplayName("Test for book id uniqueness")
    void testUniqueId() {
        BookIdGenerator.init();

        Book[] books = new Book[1000];
        for (int i = 0; i < 1000; i++) {
            books[i] = new Book("Java", "Tirth", 14.5f, 1);
        }

        for (Book book : books) {
            for (Book compareBook : books) {
                if (!book.equals(compareBook)){
                    assertNotEquals(book.getBookId(), compareBook.getBookId());
                }
            }
        }
    }
}
