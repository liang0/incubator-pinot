/**
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
package org.apache.pinot.core.segment.index.readers;

import org.apache.pinot.core.segment.memory.PinotDataBuffer;


public class DoubleDictionary extends ImmutableDictionaryReader {

  public DoubleDictionary(PinotDataBuffer dataBuffer, int length) {
    super(dataBuffer, length, Double.BYTES, (byte) 0);
  }

  @Override
  public int indexOf(Object rawValue) {
    int index = insertionIndexOf(rawValue);
    return (index >= 0) ? index : -1;
  }

  @Override
  public int insertionIndexOf(Object rawValue) {
    double value;
    if (rawValue instanceof String) {
      value = Double.parseDouble((String) rawValue);
    } else {
      value = (Double) rawValue;
    }
    return binarySearch(value);
  }

  @Override
  public Double get(int dictId) {
    return getDouble(dictId);
  }

  @Override
  public int getIntValue(int dictId) {
    return (int) getDouble(dictId);
  }

  @Override
  public long getLongValue(int dictId) {
    return (long) getDouble(dictId);
  }

  @Override
  public float getFloatValue(int dictId) {
    return (float) getDouble(dictId);
  }

  @Override
  public double getDoubleValue(int dictId) {
    return getDouble(dictId);
  }

  @Override
  public String getStringValue(int dictId) {
    return Double.toString(getDouble(dictId));
  }
}
