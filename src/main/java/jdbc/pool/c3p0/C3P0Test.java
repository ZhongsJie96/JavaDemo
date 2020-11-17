package jdbc.pool.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C3P0Test {
    public static Connection connection;
    public static ComboPooledDataSource dataSource;


    public static void getDataSource() {
        dataSource = new ComboPooledDataSource();
    }

    public static void queryData() {
        try {
            connection = dataSource.getConnection();
            String sql = "select * from salaries";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("emp_no"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws Exception {
//        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
//        comboPooledDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
//        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");
//        comboPooledDataSource.setUser("root");
//        comboPooledDataSource.setPassword("");
//        Connection connection = comboPooledDataSource.getConnection();
//        System.out.println(connection);
//        connection.close();
        getDataSource();
        System.out.println(dataSource.getConnection());
//        queryData();
    }
}
