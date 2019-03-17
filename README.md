# Simple JAVA-MySQL API (README OUTDATED, NEW ONE WILL BE INSERTET IN LESS THAN 24 HOURS)
<br>
This simple Package makes the connection from JAVA to MySQL very simple. It can handle normal SQL-Querys and SQL-Statements and is dedicated for JAVA-Beginners to use a MariaDB Database.

<h2> Installation </h2>
<br>
Download the JAR-File from the "library"-folder and bind it in your IDE as a external Library. This file comes directly from mariadb.com. If you want check for a newer Version, you can find it here: https://mariadb.com/downloads/#connectors-connectors_dataaccess
<br>
<br>
Now you have to add the folder "dbConn" of this project to your Sourcecode folder ("src"). This will make the package db and the Class "Database" available for your project. For more basic funktionality you can also user the "DBConnector" Class.
<br>
<br>
<h2> Usage </h2>
<br>
<h3> Import and Constructor </h3>
<br>
Fist, bind in the package:
<br>
<br>

```
import dbConn.*;
```

To create an Instance of the Database Object you can choose between two consructors:
<br>

```java
Database example = new Database("<url>", "<database>", "<username>", "<password>");
```

or

```java
Database example = new Database("<url>", "<port>", "<database>", "<username>", "<password>");
```

<br>
Parameters of the Constructors:
<br>
<br>

|Parameter|Description|
|---|---|
|url|The URL or IP of the MariaDB-Server|
|port|The Port of the MariaDB-Server (Optional, if not used the standard port 3306 will be used)|
|database|The Name of the Database to be used|
|username|Username for the MariaDB-Server|
|password|Password for the MariaDB-Server|

<br>
<br>
<h3> Methods of the Database Object </h3>
The Database Object has different Methods to complete the most actions in the MariaDB Database. The parameters for each method have and ID reffering to a table at the end of this section, describing the funktion and type of Variable.
<br>
<br>
Create, Insert and Update:
<br>

|Method|Description|Parameter IDs|Return|
|---|---|---|---|
|create()|Creates a new Table in the Database|1, 2, 3|None|
|insert()|Inserts an new Row of data into a table|1, 4, 5|None|
|update()|Updates specific Values of specified existing rows of data|1, 4, 5, 6, 7|None|

<br>
<br>

Select:
<br>

|Method|Description|Parameters|
|---|---|---|
||||
||||
||||

<br>
<br>
Parameter Description:
<br>

|ID|Parameter|Description|
|---|---|---|
|1|String table|the name of the Table|
|2|String[] columnNames|the names of the Columns of the new table|
|3|String[] columnTypes|the types of the Columns defined in ID 2|
|4|String[] columns|the names of the columns the values should be added in|
|5|String[] values|the values to be inserted into the columns defined ID 4|
|6|String[] parameterColumns|The Names of the Columns to be searched|
|7|String[] parameterValues|The values to be searched for in the columns defined in ID 6|


<br>
<br>

<h3> Methods of the DBConnector Object </h3>
<br>
To request information from the MariaDB-Server simply use the executeQuery() Method. This method requires the normal MySQL-Querry as a String and returnes a ResultSet Object.
<br>
For all other matters use the executeStatement() Method, which requires the MySQL-Statement as a String.
