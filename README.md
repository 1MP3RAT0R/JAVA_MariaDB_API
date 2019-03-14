# Simple JAVA-MySQL API
<br>
This simple Package makes the connection from JAVA to MySQL very simple. It can handle normal SQL-Querys and SQL-Statements and is dedicated for JAVA-Beginners to use a MariaDB Database.

<h2> Installation </h2>
<br>
Download the JAR-File from the "library"-folder and bind it in your IDE as a external Library. This file comes directly from [MariaDB](mariadb.com). If you want check for a newer Version, you can find it [here](https://mariadb.com/downloads/#connectors-connectors_dataaccess).
<br>
<br>
Now you have to add the folder "[db](/db)" of this project to your Sourcecode folder ("src"). This will make the package db and the Class "DBConnector" available for your project.
<br>
<br>
<h2> Usage </h2>
<br>
To create an Instance of the DBConnector Object you can choose between two consructors:

```java
DBConnect example = new DBConnect("localhost", "database", "username", "password");
```

or

```java
DBConnect example = new DBConnect("localhost", "database", "username", "password");
```
