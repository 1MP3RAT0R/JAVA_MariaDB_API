package db;
import java.sql.*;
import java.util.concurrent.ExecutionException;

public class DBConnector {

    private Connection con;
    private String URL;
    private String username;
    private String password;

    /*
     * Constructor for the Database-Object with default MySQL Port
     *
     * @param Server_URL
     * @param Database
     * @param username
     * @param password
     */
    public DBConnector(String Server_URL, String Database, String username, String password) {
        this.URL = "jdbc:mariadb://" + Server_URL + ":3306/" + Database;
        this.username = username;
        this.password = password;
    }

    /*
     * Constructor for the Database-Object with a custom Port
     *
     * @param Server_URL
     * @param port
     * @param Database,
     * @param username
     * @param password
     */
    public DBConnector(String Server_URL, String port, String Database, String username, String password) {
        this.URL = "jdbc:mariadb://" + Server_URL + ":" + port + "/" + Database;
        this.username = username;
        this.password = password;
    }

    /*
     * Executing Statements for Updates, Drops, Creates
     *
     * @param SQL-Statement
     */
    public void executeStatement(String SQL_Statement) {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.URL, this.username, this.password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Statement state = null;
        try {
            state = conn.createStatement();
            state.executeUpdate(SQL_Statement);
            conn.close();
        } catch (SQLException e){
            System.out.println("Error: " + e.getErrorCode());
        }

    }

    /*
     * Executing select-Query
     *
     * @param SQL-Query
     */
    public ResultSet executeQuery(String SQL_Query) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.URL, this.username, this.password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        Statement state = null;
        try {
            state = conn.createStatement();
            ResultSet result = state.executeQuery(SQL_Query);
            conn.close();
            return result;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }

        return null;
    }
}
