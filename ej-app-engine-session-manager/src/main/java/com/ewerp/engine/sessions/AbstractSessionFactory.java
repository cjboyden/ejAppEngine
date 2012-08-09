package com.ewerp.engine.sessions;

import com.ewerp.engine.plugins.AbstractLifecyclePlugin;
import com.ewerp.engine.plugins.AbstractPlugin;
import com.ewerp.engine.plugins.IPlugin;

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
public abstract class AbstractSessionFactory extends AbstractLifecyclePlugin implements ISessionFactory {
    protected ISessionManager sessionManager;

    @Override
    public List<Class<?>> getInterfaces() {
        return appendInterfaces(super.getInterfaces(), new Class<?>[] {ISessionFactory.class});
    }

    @Override
    public void registerSessionManager(ISessionManager sessionManager) throws IllegalArgumentException {
        if(null == sessionManager) {
            throw new IllegalArgumentException();
        }

        this.sessionManager = sessionManager;
    }

    protected ISessionManager getSessionManager() {
        return sessionManager;
    }
}
