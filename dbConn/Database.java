package dbConn;
import java.sql.*;

public class Database {

    private DBConnector con = null;
    private final String URL = "";
    private final String port = "";
    private final String database = "";
    private final String username = "";
    private final String password = "";

    /*
     * Constructor for the Database Object
     */
    public Database() {
        this.con = new DBConnector(this.URL, this.port, this.database, this.username, this.password);
    }

    /*
     * Normal Select Operation
     *
     * @param columns the columns requested
     * @param table the table to be searched
     * @param column the columns of the search parameters
     * @param values the values of to be searched for, must have as many items as the columns to be searched
     *
     * @return the ResultSet-Object includes the SQL-Results
     */
    public ResultSet select(String[] columns, String table, String[] column, String[] values) {
        String query = "select ";
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) {
                query = query + ", " + columns[i];
            } else {
                query = query + columns[i];
            }
        }
        query = query + " from " + table + " where ";
        for (int i = 0; i < column.length; i++) {
            if (i > 0) {
                query = query + ", " + column[i] + " = '" + values[i] + "'";
            } else {
                query = query + column[i] + " = '" + values[i] + "'";
            }
        }
        return this.con.executeQuery(query);
    }

    /*
     * Obtaining the whole table (All Columns + All Rows)
     *
     * @param table the table to get the information from
     *
     * @return ResultSet all information
     */
    public ResultSet selectAll(String table) {
        return this.con.executeQuery("select * from " + table);
    }

    /*
     * Obtaining all columns of a Dataset with specific DataRows, Column and Values specify the Search Parameters
     *
     * @param table the table to be searched
     * @param column the colums of the Parameters
     * @param values the values of the Parameters
     *
     * @return ResultSet of all requested information
     */
    public ResultSet selectAllColumnsSpecificRows(String table, String[] column, String[] values) {
        String query = "select * from " + table + " where ";
        for (int i = 0; i < column.length; i++) {
            if (i > 0) {
                query = query + ", " + column[i] + " = '" + values[i] + "'";
            } else {
                query = query + column[i] + " = '" + values[i] + "'";
            }
        }
        return this.con.executeQuery(query);
    }

    /*
     * Obtaining all information in of the Specified Columns
     *
     * @param columns columns to be returned
     * @param table the table to be searched
     *
     * @return the requested information
     */
    public ResultSet selectAllRowsSpecificColumns(String[] columns, String table) {
        String query = "Select ";
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) {
                query = query + ", " + columns[i];
            } else {
                query = query + columns[i];
            }
        }
        return this.con.executeQuery(query + " from " + table);
    }

    /*
     * Inserting a new set of Data
     *
     * @param table the table
     * @param columns all columns of the table
     * @param values values for all the columns
     */
    public void insert(String table, String[] columns, String[] values) {
        String statement = "insert into " + table + " (";
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) {
                statement = statement + ", " + columns[i];
            } else {
                statement = statement + columns[i];
            }
        }
        statement = statement + ") values ('";
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                statement = statement + "', '" + values[i];
            } else {
                statement = statement + values[i];
            }
        }
        this.con.executeStatement(statement + "')");
    }

    /*
     * Update one or more Parameters in all rows the parameters apply to
     *
     * @param table the table to be updated
     * @param columns the columns to be updated
     * @param values to be written in the columns
     * @param parameterColumns the columns to be searched for the parameters
     * @param parameterValues the parameters for the search
     */
    public void update(String table, String[] columns, String[] values, String[] parameterColumns, String[] parameterValues) {
        String statement = "update " + table + " set ";
        for (int i = 0; i < columns.length; i++) {
            if (i > 0) {
                statement = statement + "', " + columns[i] + " = '" + values[i];
            } else {
                statement = statement + columns[i] + " = '" + values[i];
            }
        }
        statement = statement + "' where ";
        for (int i = 0; i < parameterColumns.length; i++) {
            if (i > 0) {
                statement = statement + "', " + parameterColumns[i] + " = '" + parameterValues[i];
            } else {
                statement = statement + parameterColumns[i] + " = '" + parameterValues[i];
            }
        }
        this.con.executeStatement(statement + "'");
    }
}
