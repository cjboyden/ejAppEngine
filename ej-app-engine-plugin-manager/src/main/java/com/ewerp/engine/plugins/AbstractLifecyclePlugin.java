package com.ewerp.engine.plugins;

import com.ewerp.engine.logging.ILog;
import com.ewerp.engine.properties.IProperties;

/**
 * Copyright 2012 Curtis Boyden
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public abstract class AbstractLifecyclePlugin extends AbstractPlugin implements ILifecycleListener {
    private ILog log;
    private IProperties properties;

    /**
     * Attempt to load {@link com.ewerp.engine.logging.ILog}, {@link com.ewerp.engine.properties.IProperties}
     * from the {@link IPluginManager}
     */
    @Override
    public void init() {
        if(null != getPluginManager()) {
            properties = (IProperties)getPluginManager().getPlugin(IProperties.class);
            log = (ILog)getPluginManager().getPlugin(ILog.class);
        }
    }

    protected ILog getLog() {
        return log;
    }

    protected IProperties getProperties() {
        return properties;
    }
}