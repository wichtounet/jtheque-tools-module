package org.jtheque.collections.tools.services.impl.database;

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

import java.sql.Connection;

/**
 * @author Baptiste Wicht
 */
public interface Database {
    /**
     * Return the driver for the connection.
     *
     * @return The string representation of the JDBC driver class.
     */
    String getDriver();

    /**
     * Close the connection to the database.
     *
     * @param connection The connection to the database.
     */
    void closeConnection(Connection connection);

    /**
     * Return the complete URL of the database.
     *
     * @param databaseName The short url to the database
     *
     * @return The connexion's URL
     */
    String getUrl(String databaseName);
}
