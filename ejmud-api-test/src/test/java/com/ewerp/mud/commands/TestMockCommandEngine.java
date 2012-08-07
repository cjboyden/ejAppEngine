package com.ewerp.mud.commands;

import com.ewerp.mud.plugins.MockPluginManager;
import org.junit.Test;
import org.junit.Assert;

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

public class TestMockCommandEngine {

    public static ICommandEngine generateCommandEngine() {
        return new MockCommandEngine();
    }

    @Test
    public void testCommandEngine() throws Exception {
        ICommandEngine commandEngine = generateCommandEngine();
        MockCommand command = new MockCommand();
        Assert.assertEquals("MockCommand is not properly initialized",0, command.executionCount);

        commandEngine.pushCommand(command);
    }
}
