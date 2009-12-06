package org.jtheque.collections.tools.services.impl.database;

/*
 * This file is part of JTheque.
 *
 * JTheque is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * JTheque is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JTheque.  If not, see <http://www.gnu.org/licenses/>.
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
     * @return The connexion's URL
     */
    String getUrl(String databaseName);
}
