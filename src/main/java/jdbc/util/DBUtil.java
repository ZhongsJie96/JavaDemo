package jdbc.util;

import java.sql.*;

public class DBUtil {
    public static final String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
    public static final String user = "root";
    public static final String password = "";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取connection对象
     *
     * @return
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public static void closeConnection(Statement statement, Connection connection) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        closeConnection(connection);
    }

    public static void closeConnection(Statement statement, Connection connection, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        closeConnection(statement, connection);
    }

}
