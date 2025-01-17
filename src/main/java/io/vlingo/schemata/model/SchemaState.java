// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.schemata.model;

import java.util.Map;

import io.vlingo.schemata.model.Id.SchemaId;
import io.vlingo.symbio.store.object.MapQueryExpression.FluentMap;
import io.vlingo.symbio.store.object.StateObject;

public class SchemaState extends StateObject {
  private static final long serialVersionUID = 1L;

  public final SchemaId schemaId;
  public final Category category;
  public final Scope scope;
  public final String description;
  public final String name;

  public static SchemaState from(SchemaId schemaId) {
    return new SchemaState(schemaId);
  }

  public static SchemaState from(final long id, final long version, final SchemaId schemaId, final Category category, final Scope scope, final String name, final String description) {
    return new SchemaState(id, version, schemaId, category, scope, name, description);
  }

  public SchemaState defineWith(final Category category, final Scope scope, final String name, final String description) {
    return new SchemaState(this.persistenceId(), this.version() + 1, this.schemaId, category, scope, name, description);
  }

  public SchemaState withCategory(final Category category) {
    return new SchemaState(this.persistenceId(), this.version() + 1, this.schemaId, category, this.scope, this.name, this.description);
  }

  public SchemaState withScope(final Scope scope) {
    return new SchemaState(this.persistenceId(), this.version() + 1, this.schemaId, this.category, scope, this.name, this.description);
  }

  public SchemaState withDescription(final String description) {
    return new SchemaState(this.persistenceId(), this.version() + 1, this.schemaId, this.category, this.scope, this.name, description);
  }

  public SchemaState withName(final String name) {
    return new SchemaState(this.persistenceId(), this.version() + 1, this.schemaId, this.category, this.scope, name, this.description);
  }

  public SchemaState redefineWith(final Category category, final Scope scope, final String name, final String description) {
    return new SchemaState(this.persistenceId(), this.version() + 1, this.schemaId, category, scope, name, description);
  }

  @Override
  public Map<String, Object> queryMap() {
    return FluentMap
            .has("organizationId", schemaId.contextId.unitId.organizationId.value)
            .and("unitId", schemaId.contextId.unitId.value)
            .and("contextId", schemaId.contextId.value)
            .and("schemaId", schemaId.value);
  }

  @Override
  public int hashCode() {
    return 31 * this.schemaId.value.hashCode();
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || other.getClass() != getClass()) {
      return false;
    } else if (this == other) {
      return true;
    }

    final SchemaState otherState = (SchemaState) other;

    return this.persistenceId() == otherState.persistenceId();
  }

  @Override
  public String toString() {
    return "SchemaState[persistenceId=" + persistenceId() +
            " version=" + version() +
            " schemaId=" + schemaId.value +
            " category=" + category.name() +
            " scope=" + scope.name() +
            " name=" + name +
            " description=" + description + "]";
  }

  private SchemaState(SchemaId schemaId) {
    this(Unidentified, 0, schemaId, Category.Unknown, Scope.Private, "", "");
  }

  private SchemaState(final long id, final long version, final SchemaId schemaId, final Category category, final Scope scope, final String name, final String description) {
    super(id, version);
    this.schemaId = schemaId;
    this.category = category;
    this.scope = scope;
    this.name = name;
    this.description = description;
  }
}
