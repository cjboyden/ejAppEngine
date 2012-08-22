package com.ewerp.engine.sessions.terminal;

import com.ewerp.engine.commands.IMessage;
import com.ewerp.engine.commands.MockMessage;
import com.ewerp.engine.plugins.MockPluginManager;
import com.ewerp.engine.sessions.MockSessionManager;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import junit.framework.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.OutputStream;

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
public class TestConsoleSession {

    @Test
    public void testConsoleSession() {
        InputStream inputStream = new ByteInputStream();
        OutputStream outputStream = new ByteOutputStream();

        MockSessionManager sessionManager = new MockSessionManager();
        MockPluginManager pluginManager = new MockPluginManager();

        MockMessage message = new MockMessage();

        ConsoleSession session = new ConsoleSession(inputStream, outputStream) {
            @Override
            public void processMessage(IMessage message) {
            }

            @Override
            public void run() {
            }
        };

        sessionManager.addSession(session);
        session.setPluginManager(null);
        session.setPluginManager(pluginManager);

        session.processMessage(null);
        session.processMessage(message);

        Assert.assertEquals(inputStream, ((ITerminalSession) session).getInputStream());
        Assert.assertEquals(outputStream, ((ITerminalSession)session).getOutputStream());

        session.shutdown();
    }
}
