package com.ewerp.engine.sessions.terminal;

import com.ewerp.engine.commands.IMessage;
import com.ewerp.engine.plugins.IPluginManager;
import com.ewerp.engine.sessions.ISession;

import java.io.IOException;
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
public abstract class ConsoleSession extends AbstractTerminalSession {
    private InputStream inputStream;
    private OutputStream outputStream;

    public ConsoleSession(InputStream inputStream, OutputStream outputStream) {
        super();
        this.inputStream = inputStream;
        this.outputStream = outputStream;

        start();
    }

    @Override
    public InputStream getInputStream() {
        return inputStream;
    }

    @Override
    public OutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public boolean isInputShutdown() {
        return null == inputStream;
    }

    @Override
    public boolean isOutputShutdown() {
        return null == outputStream;
    }

    public abstract void processMessage(IMessage message);

    public abstract void run();
}
