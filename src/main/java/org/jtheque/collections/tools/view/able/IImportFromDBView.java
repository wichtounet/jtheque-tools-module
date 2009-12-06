package org.jtheque.collections.tools.view.able;

import org.jtheque.core.managers.view.able.IView;

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