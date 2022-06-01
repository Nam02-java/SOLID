package JDBC;

import java.sql.*;

public class SystemCenter {

    private static String url = "jdbc:mysql://localhost:3306/students_data";
    private static String user = "root";
    private static String password = "123";
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    public static Connection getJDBCConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
