/*
 * Copyright 2020 Haulmont.
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

package io.jmix.core;

import java.io.InputStream;

/**
 * Interface of a component to store and load files defined by file reference.
 */
public interface FileStorage {

    /**
     * Returns the name of this storage, which will be saved in {@link FileRef}s.
     * <p>
     * Each file storage in the application should have a unique name.
     */
    String getStorageName();

    /**
     * Saves an InputStream contents into file storage.
     *
     * @param fileName    file name
     * @param inputStream input stream, must be closed in the calling code
     * @return number of bytes saved
     * @throws IllegalArgumentException if arguments are incorrect
     * @throws FileStorageException     if something goes wrong
     */
    FileRef saveStream(String fileName, InputStream inputStream);

    /**
     * Return an input stream to load a file contents.
     *
     * @param reference file reference
     * @return input stream, must be closed after use
     * @throws IllegalArgumentException if arguments are incorrect
     * @throws FileStorageException     if something goes wrong
     */
    InputStream openStream(FileRef reference);

    /**
     * Removes a file from the file storage.
     *
     * @param reference file reference
     * @throws IllegalArgumentException if file reference is invalid
     */
    void removeFile(FileRef reference);

    /**
     * Tests whether the file denoted by this file reference exists.
     *
     * @param reference file reference
     * @return true if the file denoted by this file reference exists
     * @throws IllegalArgumentException if file reference is invalid
     */
    boolean fileExists(FileRef reference);
}
