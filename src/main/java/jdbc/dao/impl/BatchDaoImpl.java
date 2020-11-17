package jdbc.dao.impl;

import jdbc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BatchDaoImpl {
    public static void main(String[] args) {

    }

    public void insertBatch() {
        Connection connection = DBUtil.getConnection();

        String sql = "insert into employees values(?,?)";
        PreparedStatement preparedStatement = null;
        // 准备批处理对象
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < 10; i++) {
                preparedStatement.setInt(1, i+100);

                preparedStatement.addBatch();
            }
            int[] ints = preparedStatement.executeBatch();
            for (int asInt : ints) {
                System.out.println(asInt);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(preparedStatement, connection);
        }
    }
}
