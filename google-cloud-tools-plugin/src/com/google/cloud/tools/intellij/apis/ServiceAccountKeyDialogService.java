/*
 * Copyright 2018 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.tools.intellij.apis;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

// TODO: should this be project level?
/** Application service that provides the handle to the IC's Service Account Key Created dialog */
public class ServiceAccountKeyDialogService {

  public DialogWrapper getDialog(@Nullable Project project, String gcpProjectId, String downloadPath) {
    return new ServiceAccountKeyDisplayDialog(project, gcpProjectId, downloadPath);
  }
}
