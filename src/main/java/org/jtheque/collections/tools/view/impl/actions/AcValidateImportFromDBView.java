package org.jtheque.collections.tools.view.impl.actions;

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
