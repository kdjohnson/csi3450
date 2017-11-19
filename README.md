# csi3450

## Requirements
1. Java
2. [PostgreSQL](https://www.postgresql.org/download/)

## Setup PostgreSQ
* Launch interative terminal
    * On Linux `sudo -u postgres -i`
    * On macOS `psql postgres`
* Create a user
    * `create user YOURUSERNAME with password 'YOURPASSWORD';`
    * For pgAdmin using the following [doc](https://www.pgadmin.org/docs/pgadmin4/dev/pgadmin_user.html)
* Create a databsae
    * `create database YOURDATBASENAME owner YOURUSERNAME;`

## Setup application.properties
* Inside [application.properties](./src/main/resources/application.properties)
* Add the following
```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/DATABASE_NAME
spring.datasource.username=USERNAME_YOU_CREATED
spring.datasource.password=@password@
```


## How to build
* On macOS/Linux
    * `./gradlew clean bootRun -Dpassword=PASSWORD_FOR_USER`

* On Windows
    * `gradlew clean bootRun -Dpassword=PASSWORD_FOR_USER`

* Then go to [localhost](http://localhost) and you should see It works!