/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.module.tooling.internal.data;

import static java.util.Collections.emptySet;
import static java.util.Optional.ofNullable;
import org.mule.runtime.api.value.ResolvingFailure;
import org.mule.runtime.module.tooling.api.data.DataResult;
import org.mule.runtime.module.tooling.api.data.DataValue;

import java.util.Optional;
import java.util.Set;

public class DefaultDataResult implements DataResult {

  private final String resolverName;
  private final Set<DataValue> data;
  private final ResolvingFailure resolvingFailure;

  public DefaultDataResult(String resolverName,
                           Set<DataValue> data) {
    this.resolverName = resolverName;
    this.data = data;
    this.resolvingFailure = null;
  }

  public DefaultDataResult(String elementName,
                           ResolvingFailure resolvingFailure) {
    this.resolverName = elementName;
    this.resolvingFailure = resolvingFailure;
    this.data = emptySet();
  }

  @Override
  public String getResolverName() {
    return this.resolverName;
  }

  @Override
  public Set<DataValue> getData() {
    return this.data;
  }

  @Override
  public Optional<ResolvingFailure> getFailure() {
    return ofNullable(resolvingFailure);
  }

}
