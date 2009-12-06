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
 * A combo box model to display the available database protocols.
 *
 * @author Baptiste Wicht
 */
public final class AvailableProtocolsComboBoxModel extends DefaultComboBoxModel {
    private static final long serialVersionUID = 7852703992075184072L;

    @Resource
    private IDatabaseService databaseService;

    private final String[] databases;

    /**
     * Construct a new AvailableProtocolsComboBoxModel.
     */
    public AvailableProtocolsComboBoxModel() {
        super();

        Managers.getManager(IBeansManager.class).inject(this);

        databases = databaseService.getAvailableDatabases().toArray(new String[databaseService.getAvailableDatabases().size()]);
    }

    @Override
    public Object getElementAt(int index) {
        return databases[index];
    }

    @Override
    public int getSize() {
        return databases.length;
    }

    /**
     * Return the selected protocol.
     *
     * @return The selected protocol.
     */
    public String getSelectedProtocol() {
        return (String) getSelectedItem();
    }
}