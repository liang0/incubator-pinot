/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.pinot.thirdeye.detection.validators;

import javax.xml.bind.ValidationException;
import org.apache.pinot.thirdeye.datalayer.dto.AbstractDTO;


/**
 * Validate a config
 * @param <T> the type of the config
 */
interface ConfigValidator<T extends AbstractDTO> {
  /**
   * Validate the configuration. Thrown a validation exception if validation failed.
   * @param config the config
   * @throws ValidationException the validation exception with error message
   */
  void validateConfig(T config) throws ValidationException;

  /**
   * Validate the configuration. Thrown a validation exception if validation failed.
   * @param updatedConfig the new config
   * @param oldConfig the old config
   * @throws ValidationException the validation exception with error message
   */
  void validateUpdatedConfig(T updatedConfig, T oldConfig) throws ValidationException;
}
