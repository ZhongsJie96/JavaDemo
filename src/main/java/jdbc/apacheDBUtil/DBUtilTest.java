package jdbc.apacheDBUtil;

import jdbc.entity.Employees;
import jdbc.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DBUtilTest {
    public static Connection connection;

    public static void testQuery() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "select * from employees where emp_no = ?";
        QueryRunner runner = new QueryRunner();
        Employees query = runner.query(connection, sql, new BeanHandler<Employees>(Employees.class), 10001);
        System.out.println(query);
        connection.close();
    }

    public static void testList() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "select * from employees";
        QueryRunner runner = new QueryRunner();
        List<Employees> query1 = runner.query(connection, sql, new BeanListHandler<Employees>(Employees.class));
        for (Employees employees : query1) {
            System.out.println(employees);
        }
        connection.close();
    }

    public static void testArray() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "select * from employees";
        QueryRunner runner = new QueryRunner();
        Object[] query = runner.query(connection, sql, new ArrayHandler());
        for (Object o : query) {
            System.out.println(o);

        }
        connection.close();
    }
    public static void testArrayList() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "select * from employees";
        QueryRunner runner = new QueryRunner();
        List<Object[]> query1 = runner.query(connection, sql, new ArrayListHandler());
        for (Object[] objects : query1) {
            System.out.println(objects[0]);
            System.out.println(objects[1]);
        }
        connection.close();
    }

    public static void testMap() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "select * from employees";
        QueryRunner runner = new QueryRunner();
        Map<String, Object> query = runner.query(connection, sql, new MapHandler());
        Set<Map.Entry<String, Object>> entries = query.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            System.out.println(entry.getValue());
        }

        connection.close();
    }
    public static void testMapList() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "select * from employees";
        QueryRunner runner = new QueryRunner();
        List<Map<String, Object>> query = runner.query(connection, sql, new MapListHandler());
        for (Map<String, Object> stringObjectMap : query) {
            stringObjectMap.forEach((k, v)-> System.out.println("key: " + k + ", value： " + v));
        }

        connection.close();
    }

    public static void testScalar() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "select * from employees";
        QueryRunner runner = new QueryRunner();
        Object query = runner.query(connection, sql, new ScalarHandler<>());
        System.out.println(query);
        connection.close();
    }


    public static void testInsert() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "insert into teacher(t_id) values(?)";
        QueryRunner runner = new QueryRunner();
        int update = runner.update(connection, sql, 10);
        connection.close();
    }

    public static void testDelete() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "delete from teacher where t_id = ?";
        QueryRunner queryRunner = new QueryRunner();
        int update = queryRunner.update(connection, sql, 10);
        connection.close();
    }

    public static void testUpdate() throws SQLException {
        connection = DBUtil.getConnection();
        String sql = "update teacher set t_name = ? where t_id = ?";
        QueryRunner queryRunner = new QueryRunner();
        queryRunner.update(connection, sql, "赵六", 10);
        connection.close();
    }




    public static void main(String[] args) throws SQLException {
//        testQuery();
//        testList();
//        testArray();
//        testArrayList();
//        testMap();
//        testMapList();
//        testScalar();
//        testInsert();
        testDelete();
//        testUpdate();
    }


}
