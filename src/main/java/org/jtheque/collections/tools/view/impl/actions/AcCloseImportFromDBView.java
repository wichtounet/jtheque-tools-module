package org.jtheque.collections.tools.view.impl.actions;

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

import org.jtheque.collections.tools.view.able.IImportFromDBView;
import org.jtheque.core.managers.Managers;
import org.jtheque.core.managers.beans.IBeansManager;
import org.jtheque.core.managers.view.impl.actions.JThequeAction;

import java.awt.event.ActionEvent;

/**
 * Action to launch the import from an other database.
 *
 * @author Baptiste Wicht
 */
public final class AcCloseImportFromDBView extends JThequeAction {
    /**
     * Construct a new AcValidateImportFromDBView with a specific key.
     */
    public AcCloseImportFromDBView() {
        super("generic.view.actions.cancel");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Managers.getManager(IBeansManager.class).<IImportFromDBView>getBean("importFromDBView").closeDown();
    }
}