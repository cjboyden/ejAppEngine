package com.ewerp.mud.sessions;

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

import com.ewerp.mud.plugins.IPluginManager;

/**
 * Generates sessions and registers them with the associated {@link ISessionManager}.
 *
 * @author cboyden
 */
public interface ISessionFactory {
    /**
     * Register an {@link ISessionManager} with this {@link ISessionFactory} that this
     * {@link ISessionFactory} should register new {@link ISession}s with.
     *
     * @param sessionManager The {@link ISessionManager} with which to register new {@link ISession}s. <br />
     *                       <ul>
     *                       <li>{@link ISessionManager} : A valid session manager implementing
     *                       {@link ISessionManager}</li>
     *                       <li>null : A null value will result in an
     *                       {@link IllegalArgumentException}</li>
     *                       </ul>
     * @throws IllegalArgumentException Must be thrown if {@link IPluginManager} is null
     */
    public void registerSessionManager(ISessionManager sessionManager) throws IllegalArgumentException;
}
