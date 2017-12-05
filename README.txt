# csi3450

## Requirements

1. Java 8
2. [PostgreSQL](https://www.postgresql.org/download/)
3. [PgAdmin](https://www.pgadmin.org/download/pgadmin-3-windows/) (Windows)

## Setup PostgreSQL for MacOS/Linux

1. Open terminal.
2. Launch interative terminal

   * On Linux `sudo -u postgres -i`
   * On macOS `psql postgres`

3. Create a database

   * `create database regal_airways;`

4. Exit interactive terminal for postgres

   * `Ctrl+d`

5. Clone or download project.

   * From moodle submission
   * [Github](https://github.com/kdjohnson/csi3450)

## Setup PostgresSQL on Windows with PgAdmin

1. Open pgAdmin4
2. Click on the server drop down and enter your password.
3. Right-click on the server and select Create database.
4. Name it `regal_airways`.
5. Open git-bash or terminal of choice.
6. Travel to project root directory.
7. Run `./gradlew.bat clean bootRun`.

## Run project

* On macOS/Linux
  * `./gradlew clean bootRun`
* On windows
  * `./gradlew.bat clean bootRun`

## Tested on

* Macbook, macOS High Sierra
* MSI Laptop, Windows 7
* Asus Laptop, Windows 8
