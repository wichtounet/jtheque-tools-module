package org.jtheque.collections.tools.services.able;

import org.jtheque.collections.tools.utils.DatabaseConnectionInfos;

import java.util.Collection;

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

/**
 * @author Baptiste Wicht
 */
public interface IDatabaseService {
    /**
     * Return all the available database versions.
     *
     * @return An array of String containing all the versions of the available database.
     */
    String[] getAvailableDatabaseVersions();

    /**
     * Return all the available databases protocols.
     *
     * @return The available databases protocols
     */
    Collection<String> getAvailableDatabases();

    /**
     * Import data from an another database to the current.
     *
     * @param dbVersion  The version of the other database.
     * @param connection The informations to connect to the other database.
     *
     * @throws Exception When an errors occurs during the database operations.
     */
    void importData(String dbVersion, DatabaseConnectionInfos connection) throws Exception;
}