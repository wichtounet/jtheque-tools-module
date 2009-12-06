package org.jtheque.collections.tools.services.impl.importer;

import org.jtheque.core.managers.file.able.FileType;

import java.util.HashMap;
import java.util.Map;

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
 * A factory for DB importer.
 *
 * @author Baptiste Wicht
 */
public final class DBImporterFactory {
    private static final Map<String, DBImporter> IMPORTERS;

    /**
     * Utility class, not instanciable.
     */
    private DBImporterFactory() {
        super();
    }

    static {
        IMPORTERS = new HashMap<String, DBImporter>(2);

        IMPORTERS.put("JTheque V3", new SimpleDBImporter(FileType.V3));
        IMPORTERS.put("JTheque V4", new SimpleDBImporter(FileType.V4));
    }

    /**
     * Return the importer for the specified database.
     *
     * @param database The searched database.
     * @return the importer.
     */
    public static DBImporter getImporter(String database) {
        if (IMPORTERS.containsKey(database)) {
            return IMPORTERS.get(database);
        }

        throw new IllegalArgumentException("There is no importer for this database (" + database + ')');
    }
}
