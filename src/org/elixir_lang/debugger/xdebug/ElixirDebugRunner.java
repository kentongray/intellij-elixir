/*
 * Copyright 2012-2014 Sergey Ignatov
 * Copyright 2017 Jake Becker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.elixir_lang.debugger.xdebug;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.RunProfile;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.executors.DefaultDebugExecutor;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.execution.runners.GenericProgramRunner;
import com.intellij.execution.ui.RunContentDescriptor;
import com.intellij.xdebugger.XDebugProcess;
import com.intellij.xdebugger.XDebugProcessStarter;
import com.intellij.xdebugger.XDebugSession;
import com.intellij.xdebugger.XDebuggerManager;
import org.elixir_lang.mix.runner.MixRunConfigurationBase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ElixirDebugRunner extends GenericProgramRunner {
  private static final String ELIXIR_DEBUG_RUNNER_ID = "ElixirDebugRunner";

  @Nullable
  @Override
  protected RunContentDescriptor doExecute(@NotNull RunProfileState state,
                                           @NotNull final ExecutionEnvironment environment) throws ExecutionException {
    XDebuggerManager xDebuggerManager = XDebuggerManager.getInstance(environment.getProject());
    return xDebuggerManager.startSession(environment, new XDebugProcessStarter() {
      @NotNull
      @Override
      public XDebugProcess start(@NotNull XDebugSession session) throws ExecutionException {
        return new ElixirXDebugProcess(session, environment);
      }
    }).getRunContentDescriptor();
  }

  @NotNull
  @Override
  public String getRunnerId() {
    return ELIXIR_DEBUG_RUNNER_ID;
  }

  @Override
  public boolean canRun(@NotNull String executorId, @NotNull RunProfile profile) {
    return DefaultDebugExecutor.EXECUTOR_ID.equals(executorId) &&
      profile instanceof MixRunConfigurationBase;
  }
}
