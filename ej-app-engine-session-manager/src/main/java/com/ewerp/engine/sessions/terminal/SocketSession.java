package com.ewerp.engine.sessions.terminal;

import com.ewerp.engine.commands.ICommand;
import com.ewerp.engine.commands.IMessage;
import com.ewerp.engine.plugins.IPluginManager;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;

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

/**
 * The {@link SocketSession} wraps a socket connection and provides an interface between a Terminal
 * connection and the {@link ICommand} / {@link IMessage} system.
 *
 * {@link SocketSession}s are generated by the {@link SocketSessionFactory} when a new socket
 * connection is detected.
 */
public abstract class SocketSession implements ITerminalSession, Runnable {
    private Thread sessionThread;
    private Socket socket;

    private AtomicBoolean shutdown = new AtomicBoolean(false);

    protected IPluginManager pluginManager;

    public SocketSession(Socket socket) {
        this.socket = socket;
        this.sessionThread = new Thread(this);

        this.sessionThread.start();
    }

    @Override
    public void setPluginManager(IPluginManager pluginManager) {
        this.pluginManager = pluginManager;
    }

    // Close socket connection gracefully per a standard terminal connection
    @Override
    public void shutdown() {
        shutdown.set(true);

        if(null != sessionThread && sessionThread.isAlive()) {
            sessionThread.interrupt();
        }
    }

    /**
     * Get the input stream for the current connection
     * @return Input stream to read from terminal connection; Null if not connected
     */
    @Override
    public InputStream getInputStream() {
        InputStream result = null;

        try {
            if(null != socket && !socket.isInputShutdown()) {
                result = socket.getInputStream();
            }
        } catch (IOException e) {
            //TODO: Log
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Get the output stream for the current connection
     * @return Output stream to write for terminal connection; Null if not connected
     */
    @Override
    public OutputStream getOutputStream() {
        OutputStream result = null;

        try {
            if(null != socket && !socket.isOutputShutdown()) {
                result = socket.getOutputStream();
            }
        } catch (IOException e) {
            //TODO: Log
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean isInputShutdown() {
        boolean result = true;

        if(!socket.isClosed() && !socket.isInputShutdown()) {
            result = false;
        }

        return result;
    }

    @Override
    public boolean isOutputShutdown() {
        boolean result = true;

        if(!socket.isClosed() && !socket.isOutputShutdown()) {
            result = false;
        }

        return result;
    }


    public abstract void processMessage(IMessage message);

    public abstract void run();
}