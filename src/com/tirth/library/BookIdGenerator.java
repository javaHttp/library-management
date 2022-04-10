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

/**
 * Generates unique bookId for {@code Book}s to be stored in library.
 *
 * @author tirth
 */
public class BookIdGenerator {

    private static final int[] bookIds = new int[100];
    private static int count = 0;

    /**
     * Generates unique bookId for {@code Book}s to be stored in library.
     *
     * @return unique bookId
     */
    public static int generateBookId() {
        if (count == bookIds.length) {
            return -1;
        }
        int bookId = bookIds[count];
        count++;
        return bookId;
    }

    /**
     * Initializes bookIds array with unique bookIds.
     */
    public static void init() {
        for (int i = 0; i < bookIds.length; i++) {
            int bookId = 0;
            for (int j = 0; j <= 10; j++) {
                int n = (int) (Math.random() * 10);
                if (n == 0) {
                    j--;
                    continue;
                }
                bookId = bookId * 10 + n;
            }
            bookIds[i] = bookId;
        }
    }
}
