package com.ewerp.engine.plugins;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;

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
public class TestAbstractPlugin {
    public static AbstractPlugin generateAbstractPlugin() {
        return new AbstractPlugin() {};
    }

    @Test
    public void testAbstractPlugin() {
        AbstractPlugin plugin = generateAbstractPlugin();

        MockPluginManager pluginManager = new MockPluginManager();

        plugin.registerPluginManager(pluginManager);
        Assert.assertSame(pluginManager, plugin.getPluginManager());

        Assert.assertNull(plugin.getInterfaces());

        plugin.clearInterfaces();
        Assert.assertNull(plugin.getInterfaces());

        plugin.appendInterfaces(new Class<?>[] {TestAbstractPlugin.class, AbstractPlugin.class});

        Assert.assertNotNull(plugin.getInterfaces());
        Assert.assertEquals(2, plugin.getInterfaces().size());

        plugin.appendInterfaces(new Class<?>[] {TestAbstractPlugin.class});
        Assert.assertEquals(2, plugin.getInterfaces().size());

        plugin.clearInterfaces();
        Assert.assertNull(plugin.getInterfaces());

        plugin.appendInterfaces(new Class<?>[] {TestAbstractPlugin.class, AbstractPlugin.class, TestAbstractPlugin.class});
        Assert.assertEquals(2, plugin.getInterfaces().size());

        plugin.registerPluginManager(null);
        Assert.assertNull(plugin.getPluginManager());
    }
}
