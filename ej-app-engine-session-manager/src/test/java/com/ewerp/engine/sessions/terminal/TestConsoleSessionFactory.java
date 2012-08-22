package com.ewerp.engine.sessions.terminal;

import com.ewerp.engine.commands.IMessage;
import com.ewerp.engine.plugins.IPlugin;
import com.ewerp.engine.plugins.MockPluginManager;
import com.ewerp.engine.properties.MockProperties;
import com.ewerp.engine.sessions.ISessionFactory;
import com.ewerp.engine.sessions.MockPropertiesOne;
import com.ewerp.engine.sessions.MockSessionManagerOne;
import junit.framework.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

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
public class TestConsoleSessionFactory {
    public static ISessionFactory generateSessionFactory() {
        return new ConsoleSessionFactory() {
            @Override
            protected ITerminalSession createConsoleSession(InputStream inputStream, OutputStream outputStream) {
                return new ConsoleSession(inputStream, outputStream) {
                    @Override
                    public void processMessage(IMessage message) {
                    }

                    @Override
                    public void run() {
                    }
                };
            }
        };
    }

    @Test
    public void testDefaultConfiguration() throws InterruptedException {
        ISessionFactory sessionFactory = generateSessionFactory();

        MockSessionManagerOne mockSessionManager = new MockSessionManagerOne();

        mockSessionManager.addSessionFactory(sessionFactory);
        sessionFactory.registerSessionManager(mockSessionManager);

        Assert.assertNotNull(mockSessionManager.sessionFactoryList);
        Assert.assertEquals(1, mockSessionManager.sessionFactoryList.size());

        mockSessionManager.init();
        mockSessionManager.start();

        Assert.assertNotNull(mockSessionManager.sessionList);
        Assert.assertEquals(1, mockSessionManager.sessionList.size());
        Assert.assertTrue(mockSessionManager.sessionList.get(0) instanceof ConsoleSession);

        mockSessionManager.stop();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullSessionManager() {
        ISessionFactory sessionFactory = generateSessionFactory();
        sessionFactory.registerSessionManager(null);
    }
}
