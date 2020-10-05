# Web Development with Quarkus

## How to create a project Quarkus

- Quarkus.io
    - https://code.quarkus.io/
- Microprofile.io
    - https://start.microprofile.io/
- Visual Studio
    - Install Red Hat extension 'Quarkus'
- Eclipse
    - Install Red Hat extension 'Quarkus Tools'
- Maven
    - `mvn io.quarkus:quarkus-maven-plugin:1.8.1.Final:create`
    - To run : 
        - `cd <your project>`
        - `mvn quarkus:dev`

## Adding Quarkus extensions

- `mvn quarkus:list-extensions`
- `mvn quarkus:add-extension -Dextensions="quarkus-smallrye-openapi, quarkus-hibernate-orm-panache, quarkus-jdbc-mysql, quarkus-resteasy-jsonb, quarkus-smallrye-health"`

## Docker

- **DB** : `docker run -d --name mysql-microprofile-quarkus -p 3306:3306 -e "MYSQL_ROOT_PASSWORD=root" -e "MYSQL_DATABASE=microprofile_quarkus" mysql`

## URLs

- http://localhost:8080/
- http://localhost:8080/swagger-ui/
- http://localhost:8080/xxx (fake URL to see all URLs available)

## Useful URLs 

- https://hub.docker.com/_/mysql
- https://www.testcontainers.org/
- https://www.testcontainers.org/modules/databases/mysql/

## SPECIAL THANKS TO 
* Platform : [Udemy](https://www.udemy.com/) 
* Course : [Desenvolvimento Web com Quarkus - Básico](https://www.udemy.com/course/des-web-quarkus-basico/learn/lecture/17847294)
* Instructor : [Vinícius Ferraz Campos Florentino](https://github.com/viniciusfcf)

---
---

# microprofile-quarkus project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```
./mvnw quarkus:dev
```

## Packaging and running the application

The application can be packaged using `./mvnw package`.
It produces the `microprofile-quarkus-1.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

The application is now runnable using `java -jar target/microprofile-quarkus-1.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: `./mvnw package -Pnative`.

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: `./mvnw package -Pnative -Dquarkus.native.container-build=true`.

You can then execute your native executable with: `./target/microprofile-quarkus-1.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/building-native-image.
