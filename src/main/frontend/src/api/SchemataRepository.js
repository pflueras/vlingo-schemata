import Repository from '@/api/Repository'


const resources = {
  organizations: () => '/organizations',
  organization: (o) => `${resources.organizations()}/${o}`,
  units: (o) => `${resources.organization(o)}/units`,
  unit: (o, u) => `${resources.units(o)}/${u}`,
  contexts: (o, u) => `${resources.unit(o, u)}/contexts`,
  context: (o, u, c) => `${resources.contexts(o, u)}/${c}`,
  categories: () => '/schema/categories',
  scopes: () => '/schema/scopes',
  schemata: (o, u, c) => `${resources.context(o, u, c)}/schemas`,
  schema: (o, u, c, s) => `${resources.schemata(o, u, c)}/${s}`,
  schemaDescription: (o, u, c, s, v) => `/organizations/${o}/units/${u}/contexts/${c}/schemas/${s}/versions/${v}/description`,
  schemaSpecification: (o, u, c, s, v) => `${resources.version(o, u, c, s, v)}/specification`,
  versions: (o, u, c, s) => `${resources.schema(o, u, c, s)}/versions`,
  version: (o, u, c, s, v) => `${resources.versions(o, u, c, s)}/${v}`,
  versionStatus: (o, u, c, s, v) => `${resources.version(o, u, c, s, v)}/status`,
  sources: (o, u, c, s, v, lang) => `/code/${o}:${u}:${c}:${s}:${v}/${lang}`,
}

function ensure(response, status) {
  if (response.status !== status) {
    throw Error(`HTTP ${response.status}: ${response.statusText} (${response.config.url}).`);
  }
  return response;
}

function ensureOk(response) {
  return ensure(response, 200);
}

function ensureCreated(response) {
  return ensure(response, 201);
}

export default {
  getOrganizations() {
    return Repository.get(resources.organizations())
      .then(ensureOk)
      .then(response => response.data)
  },
  getOrganization(organization) {
    return Repository.get(resources.organization(organization))
      .then(ensureOk)
      .then(response => response.data)
  },

  getUnits(organization) {
    return Repository.get(resources.units(organization))
      .then(ensureOk)
      .then(response => response.data)
  },
  getUnit(organization, unit) {
    return Repository.get(resources.unit(organization, unit))
      .then(ensureOk)
      .then(response => response.data)
  },

  getContexts(organization, unit) {
    return Repository.get(resources.contexts(organization, unit))
      .then(ensureOk)
      .then(response => response.data)
  },
  getContext(organization, unit, context) {
    return Repository.get(resources.context(organization, unit, context))
      .then(ensureOk)
      .then(response => response.data)
  },

  getCategories() {
    return Repository.get(resources.categories())
      .then(ensureOk)
      .then(response => response.data)
  },
  getScopes() {
    return Repository.get(resources.scopes())
      .then(ensureOk)
      .then(response => response.data)
  },
  getSchemata(organization, unit, context) {
    return Repository.get(resources.schemata(organization, unit, context))
      .then(ensureOk)
      .then(response => response.data)
  },
  getSchema(organization, unit, context, schema) {
    return Repository.get(resources.schema(organization, unit, context, schema))
      .then(ensureOk)
      .then(response => response.data)
  },

  getVersions(organization, unit, context, schema) {
    return Repository.get(resources.versions(organization, unit, context, schema))
      .then(ensureOk)
      .then(response => response.data)
  },
  getVersion(organization, unit, context, schema, version) {
    return Repository.get(resources.version(organization, unit, context, schema, version))
      .then(ensureOk)
      .then(response => response.data)
  },

  createOrganization(name, description) {
    return Repository.post(resources.organizations(),
      {
        organizationId: '',
        name: name,
        description: description
      }
      )
      .then(ensureCreated)
      .then(response => response.data)
  },
  updateOrganization(id, name, description) {
    return Repository.put(resources.organization(id), {
        organizationId: id,
        name: name,
        description: description
      })
      .then(ensureOk)
      .then(response => response.data)
  },
  createUnit(organization, name, description) {
    return Repository.post(resources.units(organization),
      {
        unitId: '',
        name: name,
        description: description
      }
      )
      .then(ensureCreated)
      .then(response => response.data)
  },
  updateUnit(organization, id, name, description) {
    return Repository.put(resources.unit(organization, id), {
        unitId: id,
        name: name,
        description: description
      })
      .then(ensureOk)
      .then(response => response.data)
  },

  createContext(organization, unit, namespace, description) {
    return Repository.post(resources.contexts(organization, unit),
      {
        contextId: '',
        namespace: namespace,
        description: description
      })
      .then(ensureCreated)
      .then(response => response.data)
  },
  updateContext(organizationId, unitId, id, namespace, description) {
    return Repository.put(resources.context(organizationId, unitId, id), {
        contextId: id,
        namespace: namespace,
        description: description
      })
      .then(ensureOk)
      .then(response => response.data)
  },

  createSchema(organization, unit, context, name, scope, category, description) {
    return Repository.post(resources.schemata(organization, unit, context),
      {
        schemaId: '',
        name: name,
        scope: scope,
        category: category,
        description: description
      })
      .then(ensureCreated)
      .then(response => response.data)
  },
  updateSchema(organizationId, unitId, contextId, id, name, category, scope, description) {
    return Repository.put(resources.schema(organizationId, unitId, contextId, id), {
        schemaId: id,
        name: name,
        scope: scope,
        category: category,
        description: description
      })
      .then(ensureOk)
      .then(response => response.data)
  },
  createSchemaVersion(
    organization, unit, context, schema,
    specification, description, previousVersion, currentVersion) {
    return Repository.post(resources.versions(organization, unit, context, schema),
      {
        schemaVersionId: '',
        specification: specification,
        previousVersion: previousVersion,
        currentVersion: currentVersion,
        description: description
      }
      )
      .then(ensureCreated)
      .then(response => response.data)
  },
  saveSchemaVersionSpecification(
    organization, unit, context, schema, version, specification) {
    let config = {
      headers: {
        'Content-Type': 'application/json'
      },
      responseType: 'text'
    };
    return Repository.patch(
      resources.schemaSpecification(organization, unit, context, schema, version),
      specification,
      config
      )
      .then(ensureOk)
      .then(response => response.data)
  },
  saveSchemaVersionDescription(
    organization, unit, context, schema, version, description) {
    let config = {
      headers: {
        'Content-Type': 'application/json'
      },
      responseType: 'text'
    };
    return Repository.patch(
      resources.schemaDescription(organization, unit, context, schema, version),
      description,
      config
      )
      .then(ensureOk)
      .then(response => response.data)
  },
  setSchemaVersionStatus(
    organization, unit, context, schema, version, status) {

    let config = {
      headers: {
        'Content-Type': 'application/json'
      },
      responseType: 'text'
    };
    return Repository.patch(
      resources.versionStatus(organization, unit, context, schema, version),
      status,
      config
      )
      .then(ensureOk)
      .then(response => response.data)
  },
  loadSources(
    organization, unit, context, schema, version, language) {
    let config = {
      headers: {
        'Content-Type': 'application/json'
      },
      responseType: 'text'
    };
    return Promise.all([
      this.getOrganization(organization),
      this.getUnit(organization, unit),
      this.getContext(organization, unit, context),
      this.getSchema(organization, unit, context, schema),
      this.getVersion(organization, unit, context, schema, version),
    ]).then(([org, unit, context, schema, version]) => {
        return Repository.get(
          resources.sources(
            org.name,
            unit.name,
            context.namespace,
            schema.name,
            version.currentVersion,
            language), config)
      })
      .then(ensureOk)
      .then(response => response.data)
  },
}
