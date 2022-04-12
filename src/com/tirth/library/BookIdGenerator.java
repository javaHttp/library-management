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

import java.io.*;

/**
 * Generates unique bookId for {@code Book}s to be stored in library.
 *
 * @author tirth
 */
public class BookIdGenerator {

    private static int count = 0;

    /**
     * Generates unique bookId for {@code Book}s to be stored in library.
     *
     * @return unique bookId
     */
    public static int generateBookId() {
        return count++;
    }

    /**
     * Loads the last bookId generated. Creates new if not loaded.
     */
    public static void init() {
        File file = new File("last-book-id.ser");
        FileInputStream fileInputStream = null;

        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                count = (Integer) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(2);
            }
        } else {
            for (int i = 0; i <= 10; i++) {
                int tempNum = (int) (Math.random() * 100);
                count = count * 10 + tempNum;
            }
        }
    }
}
