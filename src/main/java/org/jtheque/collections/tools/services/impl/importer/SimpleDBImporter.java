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
