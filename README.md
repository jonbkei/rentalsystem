# Getting Started

## Software Requirements
 * Java SE 17
 * Maven
 * Docker & Docker compose

## Initial Setup
Install the Postgres DB with `docker-compose -f docker-compose.yml up` and then navigate to the Adminer page on `localhost:8080`.
Log in with `postgres` as Username,Password, and Database name.
Click on `SQL command` on the left sidebar and execute the contents of `database.sql` to create the necessary database tables, and example data for the application to function.

## Using the application
 * Make sure Databse is running, else start it with `docker-compose -f docker-compose.yml up`
 * Build & Run Application with `mvn spring-boot:run`
 * Application will be accessible at `localhost:8081`
 
### Used ports
 * Postgres: 5432
 * Adminer: 8080
 * Application: 8081

If any of these ports are not available, you can change them in `docker-compose.yml` and `src/main/resources/application.properties`