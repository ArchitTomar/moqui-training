Moqui Training – MySQL Configuration Setup
Overview

This repository contains my Moqui training component along with the database configuration setup using MySQL.
The objective of this assignment is to demonstrate my understanding of:

Moqui Framework setup

Database configuration using MySQL

JDBC integration

Gradle-based data loading

Basic environment configuration and version control using Git

All changes, including configuration updates and setup steps, have been properly committed to this repository.

Prerequisites

Before starting, ensure the following tools are installed on your system:

Java Development Kit (JDK 11)

Git

MySQL Server (8.0.32 or higher)

IntelliJ IDEA

Moqui Framework

GitHub Account

Verify Java installation:

java -version

Getting Started with Moqui
Step 1: Clone Moqui Framework
git clone -b master https://github.com/moqui/moqui-framework.git
cd moqui-framework

Step 2: Initialize Runtime

Moqui creates the runtime directory automatically during the first run.
Ensure the runtime directory is present after executing Gradle commands.

Step 3: Run Moqui Application
./gradlew run


Access Moqui UI:

http://localhost:8080


Default credentials:

Username: john.doe

Password: moqui

Note: ElasticSearch warnings can be safely ignored for this assignment.

Creating moqui-training Component

Location:

runtime/component/moqui-training


Standard directories created:

entity
service
screen
data


component.xml created with proper naming and version reference.

MySQL Database Configuration
Step 1: Install and Secure MySQL
mysql_secure_installation


Recommended settings:

Set root password: Yes

Remove anonymous users: Yes

Disallow root remote login: Yes

Remove test database: Yes

Reload privileges: Yes

Step 2: Add MySQL JDBC Driver

Download MySQL Connector/J 8.0.32

Place the JAR file in:

runtime/lib/


This enables Java–MySQL communication.

Step 3: Create Database and User
CREATE DATABASE moqui CHARACTER SET utf8;

CREATE USER 'moqui'@'localhost' IDENTIFIED BY '@12345abC';

GRANT ALL PRIVILEGES ON moqui.* TO 'moqui'@'localhost';

FLUSH PRIVILEGES;


The database uses UTF-8 to support international characters.

Step 4: Update MoquiDevConf.xml

File updated:

runtime/conf/MoquiDevConf.xml


Key properties configured:

Database type (MySQL)

Host: 127.0.0.1

Database name: moqui

Username and password

entity_ds_host specifies the database host.
127.0.0.1 and localhost both refer to the local machine.

Step 5: Load Data
./gradlew load


Successful load can be verified from:

System Dashboard → Data → Entities

Technical Explanations
CHARACTER SET utf8

Used for Unicode support

Ensures compatibility with multiple languages

Alternative: utf8mb4 (full Unicode including emojis)

JDBC Driver

JDBC enables Java applications to connect with databases.

Example:

Class.forName("oracle.jdbc.driver.OracleDriver");


This dynamically loads the JDBC driver into memory at runtime.

IP Address & Host

127.0.0.1 → Loopback address (local machine)

localhost → Hostname resolved to loopback IP

entity_ds_host defines where the database server is running

Deliverables Included

✅ Updated MoquiDevConf.xml

✅ MySQL database configuration

✅ moqui-training component

✅ Proper README documentation

✅ All changes committed and pushed to GitHub



Moqui Framework Documentation

MySQL JDBC Documentation

Moqui Database Configuration Guide

If you want, next I can:
