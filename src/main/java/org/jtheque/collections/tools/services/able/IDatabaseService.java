package org.jtheque.collections.tools.services.able;

import org.jtheque.collections.tools.utils.DatabaseConnectionInfos;

import java.util.Collection;

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
