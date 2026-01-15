# Moqui Training – MySQL Configuration Setup

## Overview
This repository contains the **moqui-training component** along with **MySQL database configuration** for local Moqui application development.  
The purpose of this assignment is to demonstrate practical understanding of the Moqui framework, database integration, and environment setup.

All configuration changes and setup steps have been committed to this repository.

---

## Prerequisites
Ensure the following tools are installed on your system before starting:

- Java Development Kit (**JDK 11**)
- Git
- MySQL Server (**8.0.32 or higher**)
- IntelliJ IDEA
- Moqui Framework
- GitHub Account

### Verify Java Installation
```bash
java -version
Getting Started with Moqui
Step 1: Clone the Moqui Framework
git clone -b master https://github.com/moqui/moqui-framework.git
cd moqui-framework

Step 2: Initialize Runtime

The runtime directory is created automatically during the first execution of Moqui.
Ensure that the directory exists after running any Gradle command.

Step 3: Run the Moqui Application
./gradlew run


Access the application in the browser:

http://localhost:8080


Default Login Credentials

Username: john.doe

Password: moqui

ElasticSearch warnings can be ignored for this assignment.

Creating moqui-training Component

Component Location

runtime/component/moqui-training


Standard directories created

entity/
service/
screen/
data/


A component.xml file is created with proper naming and version reference.

MySQL Database Configuration
Step 1: Install and Secure MySQL
mysql_secure_installation


Recommended configuration

Set root password: Yes

Remove anonymous users: Yes

Disallow root login remotely: Yes

Remove test database: Yes

Reload privilege tables: Yes

Step 2: Add MySQL JDBC Driver

Download MySQL Connector/J 8.0.32

Place the JAR file in:

runtime/lib/


This enables communication between Java applications and MySQL.

Step 3: Create Database and User
CREATE DATABASE moqui CHARACTER SET utf8;

CREATE USER 'moqui'@'localhost' IDENTIFIED BY '@12345abC';

GRANT ALL PRIVILEGES ON moqui.* TO 'moqui'@'localhost';

FLUSH PRIVILEGES;


The database uses UTF-8 encoding to support international characters.

Step 4: Update MoquiDevConf.xml

The following file is updated with database details:

runtime/conf/MoquiDevConf.xml


Configured properties

Database type: MySQL

Host: 127.0.0.1

Database name: moqui

Database username and password

entity_ds_host specifies the database host.
Both 127.0.0.1 and localhost refer to the local machine.

Step 5: Load Initial Data
./gradlew load


Verify successful data loading from:

System Dashboard → Data → Entities

Technical Notes
CHARACTER SET utf8

Enables Unicode character support

Ensures multi-language compatibility

Alternative: utf8mb4 (full Unicode support)

JDBC Driver

JDBC drivers allow Java applications to connect to databases.

Example:

Class.forName("oracle.jdbc.driver.OracleDriver");


This loads the JDBC driver class dynamically at runtime.

IP Address and Host

127.0.0.1 → Loopback address of the local machine

localhost → Hostname mapped to loopback IP

entity_ds_host → Specifies the database server location

Deliverables Included

Updated MoquiDevConf.xml

MySQL database configuration

moqui-training component

Setup documentation (this README)

All changes committed and pushed to GitHub

References

Moqui Framework Documentation

MySQL JDBC Documentation

Moqui Database Configuration Guide
