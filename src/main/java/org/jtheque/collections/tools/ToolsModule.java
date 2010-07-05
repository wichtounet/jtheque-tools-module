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
 * The tools module.
 *
 * @author Baptiste Wicht
 */
@Module(id = "jtheque-tools-module", i18n = "classpath:org/jtheque/collections/tools/i18n/tools",
        version = "1.0.2", core = "2.0.2", jarFile = "jtheque-tools-module-1.0.2.jar",
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
