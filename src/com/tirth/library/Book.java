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

public class Book {

    private final String title;
    private final String author;
    private final float price;
    private final int bookId;
    private int quantity;

    public Book(String title, String author, float price, int bookId, int quantity) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public float getPrice() {
        return price;
    }

    public int getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addCopies(int quantity) {
        this.quantity += quantity;
    }

    public void removeCopies(int quantity) {
        if (quantity > this.quantity) {
            throw new IllegalArgumentException("Not enough copies");
        }
        this.quantity -= quantity;
    }
}
