[![patreon](https://c5.patreon.com/external/logo/become_a_patron_button.png)](https://www.patreon.com/bePatron?u=12280211)
[![License: GPL v3](https://img.shields.io/badge/License-GPLv3-blue.svg)](https://www.gnu.org/licenses/gpl-3.0)

# JDBC and JPA Basic Code Demonstration

This project is a companion code of my blogs and videos about JDBC and JPA.

There are several Java classes that demonstrate how to connect and execute SQL commands on the different type of database.

## Pre-requisites

To be able to run this project you must have the following installed on your machine:

 - Eclipse IDE
 - MySQL WorkBench Community
 - Docker

## Running MySQL using Docker

Docker is a virtualization tool that we can use to run an application such as MySQL without actually installing it.

To install docker, follow the guide in the link in the reference section.

To run docker, open your terminal and execute:

```sh
docker run --name mysql -p 3306:3306 -e MYSQL_ROOT_PASSWORD=kerri -e MYSQL_DATABASE=catalog mysql
```

## MySQL WorkBench Installation

WorkBench installation is straight-forward for Windows you just have to download the installer from the link below and connect to your database.

On the other hand, there are some configurations/installations that you need to perform in Debian machines to install it. See the link in the reference section below.

Once the WorkBench is running you can then connect to your database with the password you entered when you run MySQL with docker. In our case we used 'kerri'.

By default, the database catalog will be created. Double click on it in the Schema tab so that it is selected and then press the "Create a new SQL tab..." button and enter the script in "src/main/resources/1 - schema.sql" to create our product table.

## Running the Tests

There are various tests that are demonstrated in this project.

### SimpleJdbcMysqlDemo

This class connects to the MySQL instance and execute CRUD operations.

## References

 - http://czetsuya-tech.blogspot.com
 - https://github.com/czetsuya
 - https://czetsuya-tech.blogspot.com/2020/05/how-to-install-mysql-workbench-in-ubuntu.html
 - https://czetsuya-tech.blogspot.com/2019/12/learn-java-programming-for-beginners.html
 - https://czetsuya-tech.blogspot.com/2019/10/eclipse-plugins-for-java-developer.html
 - https://hub.docker.com/_/mysql
 - https://www.mysql.com/products/workbench/
 - https://docs.docker.com/docker-for-windows/install/

## Authors

 * **Edward P. Legaspi** - *Java Architect* - [czetsuya](https://github.com/czetsuya)