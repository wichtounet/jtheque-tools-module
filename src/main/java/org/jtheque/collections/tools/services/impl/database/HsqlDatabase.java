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