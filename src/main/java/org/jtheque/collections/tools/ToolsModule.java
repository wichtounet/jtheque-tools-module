package org.jtheque.collections.tools;

import org.jtheque.core.managers.Managers;
import org.jtheque.core.managers.feature.Feature;
import org.jtheque.core.managers.feature.Feature.FeatureType;
import org.jtheque.core.managers.feature.IFeatureManager;
import org.jtheque.core.managers.feature.IFeatureManager.CoreFeature;
import org.jtheque.core.managers.module.annotations.Module;
import org.jtheque.core.managers.module.annotations.Plug;
import org.jtheque.core.managers.module.annotations.UnPlug;
import org.jtheque.core.managers.resource.IResourceManager;

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
 * The tools module.
 *
 * @author Baptiste Wicht
 */
@Module(id = "jtheque-tools-module", i18n = "classpath:org/jtheque/collections/tools/i18n/tools",
        version = "1.0.1-SNAPSHOT", core = "2.0.2", jarFile = "jtheque-tools-module-1.0.1-SNAPSHOT.jar",
        updateURL = "http://jtheque.developpez.com/public/versions/ToolsModule.versions")
public final class ToolsModule {
    private Feature importFromDBFeature;

    /**
     * Plug the module.
     */
    @Plug
    private void plug() {
        importFromDBFeature = new Feature();
        importFromDBFeature.setType(FeatureType.SEPARATED_ACTION);
        importFromDBFeature.setPosition(250);
        importFromDBFeature.setAction(Managers.getManager(IResourceManager.class).getAction("importFromDBAction"));

        Managers.getManager(IFeatureManager.class).getFeature(CoreFeature.FILE).addSubFeature(importFromDBFeature);
    }

    /**
     * Unplug the module.
     */
    @UnPlug
    private void unplug() {
        Managers.getManager(IFeatureManager.class).getFeature(CoreFeature.FILE).removeSubFeature(importFromDBFeature);
    }
}