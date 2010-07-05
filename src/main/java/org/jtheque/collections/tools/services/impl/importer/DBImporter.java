package org.jtheque.collections.tools.services.impl.importer;

/*
 * Copyright JTheque (Baptiste Wicht)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.jtheque.utils.io.FileException;

import java.sql.Connection;

/**
 * @author Baptiste Wicht
 */
public interface DBImporter {
    /**
     * Set the database connection.
     *
     * @param connection The database connexion.
     */
    void setDatabaseConnection(Connection connection);

    /**
     * Import the data from the Database.
     *
     * @throws FileException When an errors occurs during the restore process.
     */
    void importFromDB() throws FileException;
}
