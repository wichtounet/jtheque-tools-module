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

/**
 * An abstract database. It's used to make operations independently of the real database implementation.
 *
 * @author Baptiste Wicht
 */
public abstract class AbstractDatabase implements Database {
    /**
     * Return the prefix of the URL.
     *
     * @return The start of the url.
     */
    protected abstract String getPrefixUrl();

    @Override
    public String getUrl(String databaseName) {
        return getPrefixUrl() + databaseName;
    }
}
