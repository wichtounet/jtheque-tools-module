package org.jtheque.collections.tools.view.impl.models;

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

import org.jtheque.collections.tools.services.able.IDatabaseService;
import org.jtheque.core.managers.Managers;
import org.jtheque.core.managers.beans.IBeansManager;

import javax.annotation.Resource;
import javax.swing.DefaultComboBoxModel;

/**
 * A combo box model to display the available database versions.
 *
 * @author Baptiste Wicht
 */
public final class AvailableDatabaseVersionsComboBoxModel extends DefaultComboBoxModel {
    private static final long serialVersionUID = -4951122212082229878L;

    private final String[] versions;

    @Resource
    private IDatabaseService databaseService;

    /**
     * Construct a new AvailableDatabaseVersionsComboBoxModel.
     */
    public AvailableDatabaseVersionsComboBoxModel() {
        super();

        Managers.getManager(IBeansManager.class).inject(this);

        versions = databaseService.getAvailableDatabaseVersions();
    }

    @Override
    public Object getElementAt(int index) {
        return versions[index];
    }

    @Override
    public int getSize() {
        return versions.length;
    }

    /**
     * Return the selected version.
     *
     * @return The selected version.
     */
    public String getSelectedVersion() {
        return (String) getSelectedItem();
    }
}