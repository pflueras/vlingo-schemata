// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.schemata.model;

import io.vlingo.lattice.model.DomainEvent;
import io.vlingo.schemata.model.Id.ContextId;
import io.vlingo.schemata.model.Id.OrganizationId;
import io.vlingo.schemata.model.Id.SchemaId;
import io.vlingo.schemata.model.Id.SchemaVersionId;
import io.vlingo.schemata.model.Id.UnitId;

public final class Events {
  public static final class ContextDefined extends DomainEvent {
    public final String contextId;
    public final String name;
    public final String description;

    public static ContextDefined with(final ContextId contextId, final String namespace, final String description) {
      return new ContextDefined(contextId, namespace, description);
    }

    public ContextDefined(final ContextId contextId, final String name, final String description) {
      this.contextId = contextId.value;
      this.name = name;
      this.description = description;
    }
  }

  public static final class ContextDescribed extends DomainEvent {
    public final String contextId;
    public final String description;

    public static ContextDescribed with(final ContextId contextId, final String description) {
      return new ContextDescribed(contextId, description);
    }

    public ContextDescribed(final ContextId contextId, final String description) {
      this.contextId = contextId.value;
      this.description = description;
    }
  }

  public static final class ContextMovedToNamespace extends DomainEvent {
    public final String contextId;
    public final String namespace;

    public static ContextMovedToNamespace with(final ContextId contextId, final String namespace) {
      return new ContextMovedToNamespace(contextId, namespace);
    }

    public ContextMovedToNamespace(final ContextId contextId, String namespace) {
      this.contextId = contextId.value;
      this.namespace = namespace;
    }
  }

  public static final class ContextRedefined extends DomainEvent {
    public final String contextId;
    public final String name;
    public final String description;

    public static ContextRedefined with(final ContextId contextId, final String namespace, final String description) {
      return new ContextRedefined(contextId, namespace, description);
    }

    public ContextRedefined(final ContextId contextId, final String name, final String description) {
      this.contextId = contextId.value;
      this.name = name;
      this.description = description;
    }
  }

  public static final class OrganizationDefined extends DomainEvent {
    public final String organizationId;
    public final String name;
    public final String description;

    public static OrganizationDefined with(final OrganizationId organizationId, final String name, final String description) {
      return new OrganizationDefined(organizationId, name, description);
    }

    public OrganizationDefined(final OrganizationId organizationId, final String name, final String description) {
      this.organizationId = organizationId.value;
      this.name = name;
      this.description = description;
    }
  }

  public static final class OrganizationDescribed extends DomainEvent {
    public final String organizationId;
    public final String description;

    public static OrganizationDescribed with(final OrganizationId organizationId, final String description) {
      return new OrganizationDescribed(organizationId, description);
    }

    public OrganizationDescribed(final OrganizationId organizationId, final String description) {
      this.organizationId = organizationId.value;
      this.description = description;
    }
  }

  public static final class OrganizationRedefined extends DomainEvent {
    public final String organizationId;
    public final String name;
    public final String description;

    public static OrganizationRedefined with(final OrganizationId organizationId, final String name, final String description) {
      return new OrganizationRedefined(organizationId, name, description);
    }

    public OrganizationRedefined(final OrganizationId organizationId, final String name, final String description) {
      this.organizationId = organizationId.value;
      this.name = name;
      this.description = description;
    }
  }

  public static final class OrganizationRenamed extends DomainEvent {
    public final String organizationId;
    public final String name;

    public static OrganizationRenamed with(final OrganizationId organizationId, final String name) {
      return new OrganizationRenamed(organizationId, name);
    }

    public OrganizationRenamed(final OrganizationId organizationId, final String name) {
      this.organizationId = organizationId.value;
      this.name = name;
    }
  }

  public static final class SchemaDefined extends DomainEvent {
    public final String schemaId;
    public final String category;
    public final String scope;
    public final String name;
    public final String description;

    public static SchemaDefined with(final SchemaId schemaId, final Category category, final Scope scope, final String name, final String description) {
      return new SchemaDefined(schemaId, category, scope, name, description);
    }

    public SchemaDefined(final SchemaId schemaId, final Category category, final Scope scope, final String name, final String description) {
      this.schemaId = schemaId.value;
      this.category = category.name();
      this.scope = scope.name();
      this.name = name;
      this.description = description;
    }
  }

  public static final class SchemaDescribed extends DomainEvent {
    public final String schemaId;
    public final String description;

    public static SchemaDescribed with(final SchemaId schemaId, final String description) {
      return new SchemaDescribed(schemaId, description);
    }

    public SchemaDescribed(final SchemaId schemaId, final String description) {
      this.schemaId = schemaId.value;
      this.description = description;
    }
  }

  public static final class SchemaCategorized extends DomainEvent {
    public final String schemaId;
    public final String category;

    public static SchemaCategorized with(final SchemaId schemaId, final Category category) {
      return new SchemaCategorized(schemaId, category);
    }

    public SchemaCategorized(final SchemaId schemaId, final Category category) {
      this.schemaId = schemaId.value;
      this.category = category.name();
    }
  }

  public static final class SchemaScoped extends DomainEvent {
    public final String schemaId;
    public final String scope;

    public static SchemaScoped with(final SchemaId schemaId, final Scope scope) {
      return new SchemaScoped(schemaId, scope);
    }

    public SchemaScoped(final SchemaId schemaId, final Scope scope) {
      this.schemaId = schemaId.value;
      this.scope = scope.name();
    }
  }

  public static final class SchemaRedefined extends DomainEvent {
    public final String schemaId;
    public final String category;
    public final String scope;
    public final String name;
    public final String description;

    public static SchemaRedefined with(final SchemaId schemaId, final Category category, final Scope scope, final String name, final String description) {
      return new SchemaRedefined(schemaId, category, scope, name, description);
    }

    public SchemaRedefined(final SchemaId schemaId, final Category category, final Scope scope, final String name, final String description) {
      this.schemaId = schemaId.value;
      this.category = category.name();
      this.scope = scope.name();
      this.name = name;
      this.description = description;
    }
  }

  public static final class SchemaRenamed extends DomainEvent {
    public final String schemaId;
    public final String name;

    public static SchemaRenamed with(final SchemaId schemaId, final String name) {
      return new SchemaRenamed(schemaId, name);
    }

    public SchemaRenamed(final SchemaId schemaId, final String name) {
      this.schemaId = schemaId.value;
      this.name = name;
    }
  }

  public static final class SchemaVersionDefined extends DomainEvent {
    public final String schemaVersionId;
    public final String specification;
    public final String description;
    public final String status;
    public final String previousVersion;
    public final String nextVersion;

    public static SchemaVersionDefined with(
            final SchemaVersionId schemaVersionId,
            final SchemaVersion.Specification specification,
            final String description,
            final SchemaVersion.Status status,
            final SchemaVersion.Version previousVersion,
            final SchemaVersion.Version nextVersion) {
      return new SchemaVersionDefined(schemaVersionId, specification, description, status, previousVersion, nextVersion);
    }

    public SchemaVersionDefined(
            SchemaVersionId schemaVersionId,
            final SchemaVersion.Specification specification,
            final String description,
            final SchemaVersion.Status status,
            final SchemaVersion.Version previousVersion,
            final SchemaVersion.Version nextVersion) {
      this.schemaVersionId = schemaVersionId.value;
      this.specification = specification.value;
      this.description = description;
      this.status = status.toString();
      this.previousVersion = previousVersion.value;
      this.nextVersion = nextVersion.value;
    }
  }

  public static final class SchemaVersionDescribed extends DomainEvent {
    public final String schemaVersionId;
    public final String description;

    public static SchemaVersionDescribed with(final SchemaVersionId schemaVersionId, final String description) {
      return new SchemaVersionDescribed(schemaVersionId, description);
    }

    public SchemaVersionDescribed(final SchemaVersionId schemaVersionId, final String description) {
      this.schemaVersionId = schemaVersionId.value;
      this.description = description;
    }
  }

  public static final class SchemaVersionAssigned extends DomainEvent {
    public final String schemaVersionId;
    public final String version;

    public static SchemaVersionAssigned with(final SchemaVersionId schemaVersionId, final SchemaVersion.Version version) {
      return new SchemaVersionAssigned(schemaVersionId, version);
    }

    public SchemaVersionAssigned(SchemaVersionId schemaVersionId, final SchemaVersion.Version version) {
      this.schemaVersionId = schemaVersionId.value;
      this.version = version.value;
    }
  }

  public static final class SchemaVersionSpecified extends DomainEvent {
    public final String schemaVersionId;
    public final String specification;

    public static SchemaVersionSpecified with(SchemaVersionId schemaVersionId, final SchemaVersion.Specification specification) {
      return new SchemaVersionSpecified(schemaVersionId, specification);
    }

    public SchemaVersionSpecified(SchemaVersionId schemaVersionId, final SchemaVersion.Specification specification) {
      this.schemaVersionId = schemaVersionId.value;
      this.specification = specification.value;
    }
  }

  public static final class SchemaVersionPublished extends DomainEvent {
    public final String schemaVersionId;

    public static SchemaVersionPublished with(final SchemaVersionId schemaVersionId) {
      return new SchemaVersionPublished(schemaVersionId);
    }

    public SchemaVersionPublished(final SchemaVersionId schemaVersionId) {
      this.schemaVersionId = schemaVersionId.value;
    }
  }

  public static final class SchemaVersionDeprecated extends DomainEvent {
    public final String schemaVersionId;

    public static SchemaVersionDeprecated with(final SchemaVersionId schemaVersionId) {
      return new SchemaVersionDeprecated(schemaVersionId);
    }

    public SchemaVersionDeprecated(final SchemaVersionId schemaVersionId) {
      this.schemaVersionId = schemaVersionId.value;
    }
  }

  public static final class SchemaVersionRemoved extends DomainEvent {
    public final String schemaVersionId;

    public static SchemaVersionRemoved with(final SchemaVersionId schemaVersionId) {
      return new SchemaVersionRemoved(schemaVersionId);
    }

    public SchemaVersionRemoved(final SchemaVersionId schemaVersionId) {
      this.schemaVersionId = schemaVersionId.value;
    }
  }

  public static final class UnitDefined extends DomainEvent {
    public final String unitId;
    public final String name;
    public final String description;

    public static UnitDefined with(final UnitId unitId, final String name, final String description) {
      return new UnitDefined(unitId, name, description);
    }

    public UnitDefined(final UnitId unitId, final String name, final String description) {
      this.unitId = unitId.value;
      this.name = name;
      this.description = description;
    }
  }

  public static final class UnitDescribed extends DomainEvent {
    public final String unitId;
    public final String description;

    public static UnitDescribed with(final UnitId unitId, final String description) {
      return new UnitDescribed(unitId, description);
    }

    public UnitDescribed(final UnitId unitId, final String description) {
      this.unitId = unitId.value;
      this.description = description;
    }
  }

  public static final class UnitRedefined extends DomainEvent {
    public final String unitId;
    public final String name;
    public final String description;

    public static UnitRedefined with(final UnitId unitId, final String name, final String description) {
      return new UnitRedefined(unitId, name, description);
    }

    public UnitRedefined(final UnitId unitId, final String name, final String description) {
      this.unitId = unitId.value;
      this.name = name;
      this.description = description;
    }
  }

  public static final class UnitRenamed extends DomainEvent {
    public final String unitId;
    public final String name;

    public static UnitRenamed with(final UnitId unitId, final String name) {
      return new UnitRenamed(unitId, name);
    }

    public UnitRenamed(final UnitId unitId, final String name) {
      this.unitId = unitId.value;
      this.name = name;
    }
  }
}
