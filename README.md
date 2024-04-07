# Spring-flyway

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.flyway)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)



---

# Flyway Migration Script Naming Convention

Flyway adheres to the following naming convention for migration scripts:

`<Prefix><Version>__<Description>.sql`

Where:

- `<Prefix>` – The default prefix is `V`, which can be changed in the configuration file using the `flyway.sqlMigrationPrefix` property.
- `<Version>` – Migration version number. Major and minor versions may be separated by an underscore. The migration version should always start with 1.
- `<Description>` – Textual description of the migration. A double underscore separates the description from the version numbers.

**Example:** `V1__my_first_migration.sql`

---

