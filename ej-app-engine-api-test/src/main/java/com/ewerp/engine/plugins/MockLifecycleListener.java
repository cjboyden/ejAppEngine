package com.ewerp.engine.plugins;

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

public class MockLifecycleListener implements ILifecycleListener {
    public int initCount = 0;
    public int startCount = 0;
    public int stopCount = 0;

    @Override
    public void init() {
        initCount++;
    }

    @Override
    public void start() {
        startCount++;
    }

    @Override
    public void stop() {
        stopCount++;
    }
}
