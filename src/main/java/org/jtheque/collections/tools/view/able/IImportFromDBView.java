package org.jtheque.collections.tools.view.able;

import org.jtheque.core.managers.view.able.IView;

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
public interface IImportFromDBView extends IView {
    /**
     * Return the selected version.
     *
     * @return The selected version.
     */
    String getSelectedVersion();

    /**
     * Return the selected user name.
     *
     * @return The selected user name.
     */
    String getSelectedUserName();

    /**
     * Return the selected password.
     *
     * @return The selected password.
     */
    String getSelectedPassword();

    /**
     * Return the selected URL.
     *
     * @return The selected URL.
     */
    String getSelectedUrl();

    /**
     * Return the selected protocol.
     *
     * @return The selected protocol.
     */
    String getSelectedProtocol();
}
