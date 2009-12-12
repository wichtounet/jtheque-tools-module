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

import org.jtheque.collections.tools.services.able.IDatabaseService;
import org.jtheque.collections.tools.utils.DatabaseConnectionInfos;
import org.jtheque.collections.tools.view.able.IImportFromDBView;
import org.jtheque.core.managers.Managers;
import org.jtheque.core.managers.beans.IBeansManager;
import org.jtheque.core.managers.error.IErrorManager;
import org.jtheque.core.managers.error.InternationalizedError;
import org.jtheque.core.managers.log.ILoggingManager;
import org.jtheque.core.managers.view.impl.actions.JThequeAction;

import java.awt.event.ActionEvent;

/**
 * Action to launch the import from an other database.
 *
 * @author Baptiste Wicht
 */
public final class AcValidateImportFromDBView extends JThequeAction {
    /**
     * Construct a new AcValidateImportFromDBView with a specific key.
     */
    public AcValidateImportFromDBView() {
        super("import.database.actions.validate");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        IDatabaseService databaseService = Managers.getManager(IBeansManager.class).getBean("databaseService");
        IImportFromDBView importFromDBView = Managers.getManager(IBeansManager.class).getBean("importFromDBView");
        
        DatabaseConnectionInfos infos = new DatabaseConnectionInfos();

        infos.setPassword(importFromDBView.getSelectedPassword());
        infos.setUser(importFromDBView.getSelectedUserName());
        infos.setProtocol(importFromDBView.getSelectedProtocol());
        infos.setUrl(importFromDBView.getSelectedUrl());

        try {
            databaseService.importData(importFromDBView.getSelectedVersion(), infos);
            importFromDBView.closeDown();
        } catch (Exception e1) {
            Managers.getManager(ILoggingManager.class).getLogger(getClass()).error(e1);

            Managers.getManager(IErrorManager.class).addError(new InternationalizedError(
                    "import.database.errors.import", e1.getMessage()));
        }
    }
}