/*
 * Copyright 2018 Confluent Inc.
 *
 * Licensed under the Confluent Community License (the "License"); you may not use
 * this file except in compliance with the License.  You may obtain a copy of the
 * License at
 *
 * http://www.confluent.io/confluent-community-license
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OF ANY KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.confluent.ksql.rest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;

@Immutable
@JsonIgnoreProperties(ignoreUnknown = true)
public class FieldInfo {
  private final String name;
  private final SchemaInfo schema;

  @JsonCreator
  public FieldInfo(
      @JsonProperty("name") final String name,
      @JsonProperty("schema") final SchemaInfo schema) {
    Objects.requireNonNull(name);
    Objects.requireNonNull(schema);
    this.name = name;
    this.schema = schema;
  }


  public String getName() {
    return this.name;
  }

  public SchemaInfo getSchema() {
    return schema;
  }

  @Override
  public boolean equals(final Object other) {
    return other instanceof FieldInfo
        && Objects.equals(name, ((FieldInfo)other).name)
        && Objects.equals(schema, ((FieldInfo)other).schema);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, schema);
  }

  @Override
  public String toString() {
    return "FieldInfo{"
        + "name='" + name + '\''
        + ", schema=" + schema
        + '}';
  }
}
