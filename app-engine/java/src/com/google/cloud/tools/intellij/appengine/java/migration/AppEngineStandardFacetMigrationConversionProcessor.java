/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.tools.intellij.appengine.java.migration;

import com.google.cloud.tools.intellij.appengine.java.facet.standard.AppEngineStandardFacetType;
import com.google.common.annotations.VisibleForTesting;
import com.intellij.conversion.CannotConvertException;
import com.intellij.conversion.ConversionProcessor;
import com.intellij.conversion.ModuleSettings;

/** Performs conversions from deprecated App Engine Facets to their new version. */
public class AppEngineStandardFacetMigrationConversionProcessor
    extends ConversionProcessor<ModuleSettings> {

  @VisibleForTesting static final String DEPRECATED_APP_ENGINE_FACET_ID = "google-app-engine";

  @Override
  public boolean isConversionNeeded(ModuleSettings settings) {
    return !settings.getFacetElements(DEPRECATED_APP_ENGINE_FACET_ID).isEmpty();
  }

  /**
   * Updates the legacy app engine facet type's ID to match {@link AppEngineStandardFacetType#ID}.
   */
  @Override
  public void process(ModuleSettings settings) throws CannotConvertException {
    settings
        .getFacetElements(DEPRECATED_APP_ENGINE_FACET_ID)
        .forEach(element -> element.setAttribute("type", AppEngineStandardFacetType.STRING_ID));
  }
}
