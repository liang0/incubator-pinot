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
package org.apache.pinot.core.query.selection.iterator;

import java.io.Serializable;
import org.apache.pinot.core.common.Block;
import org.apache.pinot.core.common.BlockSingleValIterator;


/**
 * Iterator on int no dictionary column selection query.
 *
 */
public class IntSelectionColumnIterator implements SelectionColumnIterator {
  protected BlockSingleValIterator bvIter;

  public IntSelectionColumnIterator(Block block) {
    bvIter = (BlockSingleValIterator) block.getBlockValueSet().iterator();
  }

  @Override
  public Serializable getValue(int docId) {
    bvIter.skipTo(docId);
    return bvIter.nextIntVal();
  }
}
