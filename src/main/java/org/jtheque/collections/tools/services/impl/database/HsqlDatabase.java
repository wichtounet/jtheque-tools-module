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

import org.jtheque.core.managers.Managers;
import org.jtheque.core.managers.log.ILoggingManager;
import org.jtheque.utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * An HSQL Database.
 *
 * @author Baptiste Wicht
 */
public final class HsqlDatabase extends AbstractDatabase {
    @Override
    public void closeConnection(Connection connection) {
        Statement statement = null;
        ResultSet rs = null;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("SHUTDOWN");
        } catch (SQLException e) {
            Managers.getManager(ILoggingManager.class).getLogger(getClass()).error(e);
        } finally {
            DatabaseUtils.close(rs);
            DatabaseUtils.close(statement);
            DatabaseUtils.close(connection);
        }
    }

    @Override
    public String getDriver() {
        return "org.hsqldb.jdbcDriver";
    }

    @Override
    public String getPrefixUrl() {
        return "jdbc:hsqldb:file:";
    }

}
