# LASSB Transcription Center - Transcribr Service API #

## TODOs ##
- Building the WAR file.

## Local Development Configuration ##

### Properties ###

The Transcribr Service API is available in a few different environments, each of which
has its own configuration. The project supports different environments via the `profiles`
configuration in `pom.xml`.

There are currently 3 supported profiles:
- **Local**
  - Supports local development
  - Configuration is stored in `src/main/resources/application-local.properties`
- **Test**
  - Supports the LASSB test environment (lassb-vmdev01.si.edu)
  - Configuration is stored in `src/main/resources/application-test.properties`
- **Production**
  - Supports the LASSB production environments (edan-app01.si.edu, edan-app02.si.edu, edan-app03.si.edu)
  - Configuration is stored in `src/main/resources/application-prod.properties`

**THESE FILES SHOULD _NEVER_ BE COMMITTED TO THE GITHUB REPOSITORY!**

To set up your local development environment:
- Copy `application-example.properties` to a new file named `application-dev.properties`
- Modify the following settings to the correct value (they are uppercase in the file, but should
   follow appropriate casing when replaced):
  - **spring.datasource.url**
    - _DATABASE_URL_ - Should point to your local database server URL (e.g. localhost).
    - _DATABASE_PORT_ - The connection port to your local database server (e.g. 3306).
    - _DATABASE_NAME_ - The name of your local database (e.g. transcribr_service).
  - **spring.datasource.username**
    - _DATABASE_USERNAME_ - The username used to connect to your local database.
  - **spring.datasource.password**
    - _DATABASE_PASSWORD_ - The password used to connect to your local database.
  - **spring.jpa.hibernate.ddl-auto**
    - _CREATE|UPDATE|VALIDATE|NONE_ - In a development environment, this would typically be set to `create`.
  - **spring.sql.init.mode**
    - _ALWAYS|EMBEDDED_ - `always` enables script-based initialization (execute custom startup queries defined
       in src/main/resources/data.sql).
  - **spring.jpa.defer-datasource-initialization**
    - _TRUE|FALSE_ - If you want to use both Hybernate automatic schema generation AND script-based
       initialization, then set this to `true`.
  - **server.error.include-message**
    - _ALWAYS|NEVER_ - Spring Boot hides the message field in the response to avoid leaking sensitive
       information -- use this property with an `always` value to enable it.
