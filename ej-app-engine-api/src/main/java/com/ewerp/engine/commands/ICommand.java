package com.ewerp.engine.commands;

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

import com.ewerp.engine.content.IEntity;

/**
 * An {@link ICommand} is a procedure to be executed. Most commands will be
 * executed by a user with parameters.
 *
 * @author cboyden
 */
public interface ICommand {

    /**
     * Invoke the commands logic. Typically operating on the target
     * {@link IEntity} using the source {@link IEntity}.
     *
     * @throws IllegalStateException Must be thrown if the configuration of the {@link ICommand}
     *                               is invalid
     */
    public void execute() throws IllegalStateException;
}
