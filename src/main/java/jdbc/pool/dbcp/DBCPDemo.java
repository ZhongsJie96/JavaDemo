package jdbc.pool.dbcp;


import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCPDemo {

    public static void main(String[] args) {
        // DBCP连接池
        BasicDataSource basicDataSource = new BasicDataSource();
        // com.mysql.jdbc.Driver 是 mysql-connector-java 5中的，
        // com.mysql.cj.jdbc.Driver 是 mysql-connector-java 6中的
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // 指定时区 北京时间东八区
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = basicDataSource.getConnection();
            String sql = "select * from salaries";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

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
}
