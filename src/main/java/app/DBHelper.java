package app;

import java.sql.*;

public class DBHelper {

    public static Connection connection;
    public static PreparedStatement preparedStatement;
    public static Statement statement;
    public static ResultSet resultSet;
    static String urlForConnection = "jdbc:sqlite:D:\\homeworks.db";

    public static void connectionWithDB() throws SQLException {
        System.out.println("Trying to connect");
        connection = DriverManager.getConnection(urlForConnection);
        System.out.println("Connect successful");
    }

    public static void clearTable() throws SQLException {
        statement = connection.createStatement();
        statement.execute("DELETE from cities;");
        statement.execute("DELETE from city_details;");
        System.out.println("Tables are empty");
        statement.close();
    }
}