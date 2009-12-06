package org.jtheque.collections.tools.services.impl.importer;

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
import org.jtheque.core.managers.beans.IBeansManager;
import org.jtheque.core.managers.file.IFileManager;
import org.jtheque.core.managers.file.able.BackupReader;
import org.jtheque.core.managers.file.able.FileType;
import org.jtheque.utils.io.FileException;

import java.sql.Connection;

/**
 * An abstract importer for DB.
 *
 * @author Baptiste Wicht
 */
final class SimpleDBImporter implements DBImporter {
    private Connection connection;
    private final FileType type;

    /**
     * Construct a new <code>SimpleDBImporter</code>.
     *
     * @param type The type of file.
     */
    SimpleDBImporter(FileType type) {
        super();

        Managers.getManager(IBeansManager.class).inject(this);

        this.type = type;
    }

    @Override
    public void setDatabaseConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void importFromDB() throws FileException {
        for (BackupReader reader : Managers.getManager(IFileManager.class).getBackupReaders(type)) {
            reader.readBackup(connection);
        }
    }
}