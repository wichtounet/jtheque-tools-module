package org.jtheque.collections.tools.services.impl;

import org.jtheque.collections.tools.services.able.IDatabaseService;
import org.jtheque.collections.tools.services.impl.database.Database;
import org.jtheque.collections.tools.services.impl.importer.DBImporter;
import org.jtheque.collections.tools.services.impl.importer.DBImporterFactory;
import org.jtheque.collections.tools.utils.DatabaseConnectionInfos;
import org.jtheque.utils.DatabaseException;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
public final class DatabaseService implements IDatabaseService {
    /* Secondary connection */
    private Connection connection;
    private Database database;

    private final String[] versions = {"JTheque V3", "JTheque V4"};

    private Collection<String> databases;

    private static final String CONNECTION_ERROR = "Error connecting to database";

    @Override
    public String[] getAvailableDatabaseVersions() {
        return Arrays.copyOf(versions, versions.length);
    }

    @Override
    public Collection<String> getAvailableDatabases() {
        if (databases == null) {
            databases = new ArrayList<String>(2);

            databases.add("Mysql");
            databases.add("Hsql");
        }

        return databases;
    }

    /**
     * Open the connection.
     *
     * @param infos The informations for connection.
     *
     * @throws DatabaseException If an error occurs during the connection opening.
     */
    private void openConnectionForImport(DatabaseConnectionInfos infos) throws DatabaseException {
        try {
            database = (Database) Class.forName("org.jtheque.collections.tools.services.impl.database." +
                    infos.getProtocol() + "Database").newInstance();
        } catch (Exception e1) {
            throw new DatabaseException(CONNECTION_ERROR, e1);
        }

        try {
            final Driver driver = (Driver) Class.forName(database.getDriver()).newInstance();

            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(
                    database.getUrl(infos.getUrl()),
                    infos.getUser(),
                    infos.getPassword());
        } catch (Exception e) {
            throw new DatabaseException(CONNECTION_ERROR, e);
        }
    }

    /**
     * Close the connection.
     *
     * @throws DatabaseException If an error occurs during closing.
     */
    private void closeConnection() throws DatabaseException {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    database.closeConnection(connection);
                }
            } catch (SQLException e) {
                throw new DatabaseException("Error closing database connexion", e);
            }
        }
    }

    @Override
    public void importData(String dbVersion, DatabaseConnectionInfos infos) throws Exception {
        openConnectionForImport(infos);

        DBImporter importer = DBImporterFactory.getImporter(dbVersion);

        importer.setDatabaseConnection(connection);

        try {
            importer.importFromDB();
        } finally {
            closeConnection();
        }
    }
}
