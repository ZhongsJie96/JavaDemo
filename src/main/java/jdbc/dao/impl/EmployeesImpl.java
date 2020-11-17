package jdbc.dao.impl;

import jdbc.dao.EmployeesDao;
import jdbc.entity.Employees;
import jdbc.entity.Gender;
import jdbc.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class EmployeesImpl implements EmployeesDao {
    @Override
    public void insert(Employees employees) {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DBUtil.getConnection();
            // 设置自动提交
            connection.setAutoCommit(true);
            statement = connection.createStatement();
            // 字符串拼接需要注意字符串属性'的添加，日期类，枚举类
            String sql = "insert into employees values(" + employees.getEmp_no() + "," + employees.getBirth_date() + "," +
                    employees.getFirst_name() + "," + employees.getLast_name() + "," +
                    employees.getGender()  + ", " + employees.getHire_date() + ")";

            int i = statement.executeUpdate(sql);

            System.out.println("受影响的行数" + i);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(statement, connection);
        }

    }

    @Override
    public void delete(Employees employees) {

    }

    @Override
    public void update(Employees employees) {

    }

    @Override
    public Employees getEmpById(int id) {
        return null;
    }

    public static void main(String[] args) {
//        Employees employees = new Employees(10001, new Date(),"Georgi", "Facello", Gender.getByValue(1), new Date());

        // sql注入问题 ，可以使用preparedStatement
        EmployeesDao impl = new EmployeesImpl();
//        impl.insert(employees);
    }
}
