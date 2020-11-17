package jdbc;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.sql.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 如果需要链接数据库
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载驱动（通过反射）通过SPI将其中的静态代码把driver注册到DriverManage中，执行当前代码的时候，
        // 会返回一个Class对象，在创建对象的过程中，会调用具体的静态代码块
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 2.建立连接
        // 第一步已经将driver对象注册到DriverManage，可以直接通过它来获取连接
        String url = "jdbc:mysql://localhost:3306/test?serverTimezone=GMT%2B8";
        String user = "root";
        String password = "";
        Connection connection = DriverManager.getConnection(url, user, password);

        // 3. 测试连接
        System.out.println(connection);

        // 4. 定义sql语句
        String sql = "select * from course";

        // 5. 准备静态处理块对象，将sql语句放置到静态处理块中 在执行sql语句的过程中，需要一个对象来存放sql语句，
        // 将对象进行执行的时候回调用数据库的服务，数据库会从当前对象中获取sql语句
        Statement statement = connection.createStatement();

        // 6. 执行sql语句，返回值对象是结果对象 结果放到ResultSet中，是结果的一个集合，需要循环迭代获取到其中的每一条数据
        /**
         * 执行可以选择三种方式
         * 1. execute
         * 2. executeQuery
         * 3. executeUpdate
         */
        ResultSet resultSet = statement.executeQuery(sql);

        // 7. 循环处理 1）可以通过下标索引来获取 2） 通过列名来获取
        while (resultSet.next()) {
            String c_id = resultSet.getString("c_id");
            System.out.println(c_id);
        }

        // 8.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }

}
