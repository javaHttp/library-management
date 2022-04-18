/*
 * Copyright 2022 Tirth Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.tirth.library;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Library implements Serializable {

    private final String name;
    private final String address;
    private final String email;
    private final String admin;
    private final transient String password;

    private final ArrayList<Book> books;

    public Library(String name, String address, String email, String admin, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.admin = admin;
        this.password = password;

        this.books = new ArrayList<>();
        books.add(
                new Book(
                        "Library Management System",
                        "Tirth Patel",
                        0,
                        1));
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getAdmin() {
        return admin;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    public void addBookCopies(String name, int quantity) {
        Book book = searchBook(name);
        if (book == null)
            throw new IllegalArgumentException("Details of book named \"" + name + "\" not found.");
        book.addCopies(quantity);
    }

    public void addNewBook(@NotNull Book book) {
        Book existingBook = searchBook(book.getTitle());
        if (existingBook != null)
            existingBook.addCopies(book.getQuantity());
        else
            books.add(book);
    }
}
