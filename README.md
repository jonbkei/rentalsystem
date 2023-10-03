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