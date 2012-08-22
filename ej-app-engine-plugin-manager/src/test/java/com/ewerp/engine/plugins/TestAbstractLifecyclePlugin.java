package com.ewerp.engine.plugins;

import com.ewerp.engine.logging.MockLog;
import junit.framework.Assert;
import org.junit.Test;

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
public class TestAbstractLifecyclePlugin {
    public static AbstractLifecyclePlugin generateAbstractLifecyclePlugin() {
        return new AbstractLifecyclePlugin() {
            @Override
            public void start() {
            }

            @Override
            public void stop() {
            }
        };
    }

    @Test
    public void testAbstractLifecyclePlugin() {
        AbstractLifecyclePlugin plugin = generateAbstractLifecyclePlugin();

        plugin.init();

        Assert.assertNull(plugin.getLog());
        Assert.assertNull(plugin.getProperties());

        MockPluginManager pluginManager = new MockPluginManager();
        MockLogOne log = new MockLogOne();
        MockPropertiesOne properties = new MockPropertiesOne();
        pluginManager.addPlugin(log);
        pluginManager.addPlugin(properties);

        plugin.registerPluginManager(pluginManager);
        plugin.init();

        Assert.assertSame(log, plugin.getLog());
        Assert.assertSame(properties, plugin.getProperties());
    }
}
