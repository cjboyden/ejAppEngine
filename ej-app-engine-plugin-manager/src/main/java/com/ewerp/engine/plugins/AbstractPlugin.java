package com.ewerp.engine.plugins;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public abstract class AbstractPlugin implements IPlugin {
    private IPluginManager pluginManager;
    private List<Class<?>> interfaces = null;

    @Override
    public void registerPluginManager(IPluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    @Override
    public List<Class<?>> getInterfaces() {
        return interfaces;
    }

    /**
     * Clear all Interfaces that are exposed by the {@link IPlugin}.
     */
    protected void clearInterfaces() {
        interfaces = null;
    }

    /**
     * Append Interfaces that are exposed by the {@link IPlugin}.
     *
     * Duplicates will be ignored.
     *
     * @param interfaces
     * @return
     */
    protected void appendInterfaces(final Class<?>[] interfaces) {
        if(null != interfaces && interfaces.length > 0) {
            if(null == this.interfaces) {
                this.interfaces = new ArrayList<Class<?>>();
            }

            for(Class clazz : interfaces) {
                if(!this.interfaces.contains(clazz)) {
                    this.interfaces.add(clazz);
                }
            }
        }
    }

    protected IPluginManager getPluginManager() {
        return pluginManager;
    }
}