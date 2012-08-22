package com.ewerp.engine.plugins;

import com.ewerp.engine.logging.ILog;

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
public class MockLogOne extends AbstractPlugin implements ILog {
    public MockLogOne() {
        appendInterfaces(new Class<?>[] {ILog.class});
    }

    @Override
    public void logDebug(String message) {
    }

    @Override
    public void logDebug(String message, Exception e) {
    }

    @Override
    public void logDetail(String message) {
    }

    @Override
    public void logDetail(String message, Exception e) {
    }

    @Override
    public void logInfo(String message) {
    }

    @Override
    public void logInfo(String message, Exception e) {
    }

    @Override
    public void logWarn(String message) {
    }

    @Override
    public void logWarn(String message, Exception e) {
    }

    @Override
    public void logError(String message) {
    }

    @Override
    public void logError(String message, Exception e) {
    }
}
