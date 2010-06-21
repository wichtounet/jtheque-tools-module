package org.jtheque.collections.tools.view.impl.frame;

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
import org.jtheque.collections.tools.view.able.IImportFromDBView;
import org.jtheque.collections.tools.view.impl.actions.AcCloseImportFromDBView;
import org.jtheque.collections.tools.view.impl.actions.AcValidateImportFromDBView;
import org.jtheque.core.managers.error.JThequeError;
import org.jtheque.core.managers.view.impl.components.model.SimpleComboBoxModel;
import org.jtheque.core.managers.view.impl.frame.abstraction.SwingDialogView;
import org.jtheque.core.utils.ui.Borders;
import org.jtheque.core.utils.ui.PanelBuilder;
import org.jtheque.core.utils.ui.ValidationUtils;
import org.jtheque.utils.ui.GridBagUtils;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Container;
import java.awt.Frame;
import java.util.Collection;

/**
 * A view to import from a database.
 *
 * @author Baptiste Wicht
 */
public final class ImportFromDBView extends SwingDialogView implements IImportFromDBView {
    private static final long serialVersionUID = -7623407853629700329L;

    private JTextField fieldURL;
    private JTextField fieldLogin;
    private JPasswordField fieldPassword;
    private SimpleComboBoxModel<String> modelProtocols;
    private SimpleComboBoxModel<String> modelVersions;

    private static final int DEFAULT_COLUMNS = 15;

    /**
     * Construct a new JFrameImportFromDB.
     *
     * @param frame The parent frame.
     */
    public ImportFromDBView(Frame frame) {
        super(frame);

        build();
    }

    /**
     * Build the view.
     */
    private void build() {
        setContentPane(buildContentPane());
        setResizable(false);
        setTitleKey("import.database.view.title");
        pack();

        setLocationRelativeTo(getOwner());
    }

    /**
     * Build the content pane.
     *
     * @return The content pane.
     */
    private Container buildContentPane() {
        PanelBuilder builder = new PanelBuilder();

        builder.addI18nLabel("import.database.view.versions", builder.gbcSet(0, 0));

        modelVersions = new SimpleComboBoxModel<String>( < IDatabaseService > getBean("databaseService").getAvailableDatabaseVersions())
        ;

        builder.addComboBox(modelVersions, builder.gbcSet(1, 0, GridBagUtils.HORIZONTAL));

        addDatabaseInfosPanel(builder);

        builder.addButtonBar(builder.gbcSet(0, 2, GridBagUtils.NONE, GridBagUtils.BASELINE_LEADING, 2, 1),
                new AcValidateImportFromDBView(), new AcCloseImportFromDBView());

        return builder.getPanel();
    }

    /**
     * Add the panel for database informations.
     *
     * @param parent The panel builder.
     */
    private void addDatabaseInfosPanel(PanelBuilder parent) {
        PanelBuilder builder = new PanelBuilder();

        builder.getPanel().setBorder(Borders.createTitledBorder("import.database.view.connexion"));

        addLabels(builder);
        addFields(builder);

        parent.add(builder.getPanel(), parent.gbcSet(0, 1, GridBagUtils.NONE, GridBagUtils.BASELINE_LEADING, 2, 1));
    }

    /**
     * Add the labels for database informations.
     *
     * @param builder The panel builder.
     */
    private static void addLabels(PanelBuilder builder) {
        builder.addI18nLabel("config.database.view.protocol", builder.gbcSet(0, 0));
        builder.addI18nLabel("config.database.view.url", builder.gbcSet(0, 1));
        builder.addI18nLabel("config.database.view.login", builder.gbcSet(0, 2));
        builder.addI18nLabel("config.database.view.password", builder.gbcSet(0, 3));
    }

    /**
     * Add the fields for database informations.
     *
     * @param builder The panel builder.
     */
    private void addFields(PanelBuilder builder) {
        modelProtocols = new SimpleComboBoxModel<String>( < IDatabaseService > getBean("databaseService").getAvailableDatabases())
        ;
        builder.addComboBox(modelProtocols, builder.gbcSet(1, 0, GridBagUtils.HORIZONTAL));

        fieldURL = builder.add(new JTextField(DEFAULT_COLUMNS), builder.gbcSet(1, 1));
        fieldLogin = builder.add(new JTextField(DEFAULT_COLUMNS), builder.gbcSet(1, 2));
        fieldPassword = builder.add(new JPasswordField(DEFAULT_COLUMNS), builder.gbcSet(1, 3));
    }

    @Override
    public String getSelectedVersion() {
        return modelVersions.getSelectedItem();
    }

    @Override
    public String getSelectedUserName() {
        return fieldLogin.getText();
    }

    @Override
    public String getSelectedPassword() {
        return new String(fieldPassword.getPassword());
    }

    @Override
    public String getSelectedUrl() {
        return fieldURL.getText();
    }

    @Override
    public String getSelectedProtocol() {
        return modelProtocols.getSelectedItem();
    }

    @Override
    protected void validate(Collection<JThequeError> errors) {
        ValidationUtils.rejectIfNothingSelected(modelVersions, "import.database.view.versions", errors);
        ValidationUtils.rejectIfEmpty(getSelectedUserName(), "config.database.view.login", errors);
        ValidationUtils.rejectIfEmpty(getSelectedPassword(), "config.database.view.password", errors);
        ValidationUtils.rejectIfEmpty(getSelectedUrl(), "config.database.view.url", errors);
        ValidationUtils.rejectIfEmpty(getSelectedProtocol(), "config.database.view.protocol", errors);
    }
}