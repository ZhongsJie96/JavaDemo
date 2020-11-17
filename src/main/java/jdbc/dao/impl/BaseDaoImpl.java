package jdbc.dao.impl;

import jdbc.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 查询多张表的数据，但是不想写多个方法，写一个方法完成所有表的查询工作
 */
public class BaseDaoImpl {
    // 插入到sql
    public boolean insertObj(String sql, Object[] params, Class clazz) {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            pstmt = connection.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i+1, params[i]);
            }
            int i = pstmt.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public void deleteRow(String sql, Object[] params) {

    }
    /**
     * 统一查询表
     * @param sql
     * @param params
     * @param clazz
     * @return
     */
    public List getRows(String sql, Object[] params, Class clazz) {
        List list = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            pstmt = connection.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i+1, params[i]);
                }
            }
            // 开始执行查询操作
            resultSet = pstmt.executeQuery();
            // 获取结果集合的元数据对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 判断查询到的每一行记录中包含多少列
            int columnCount = metaData.getColumnCount();

            while(resultSet.next()) {
                // 创建放置具体属性的对象
                Object o = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    // 从结果集合中获取单一列的值
                    Object objectValue = resultSet.getObject(i + 1);
                    // 获取列的名称
                    String columnName = metaData.getColumnName(i+1).toLowerCase();
                    // 获取类中的属性
                    Field declaredField = clazz.getDeclaredField(columnName);
                    // 获取类中属性对应的set方法
                    Method method = clazz.getMethod(getSetName(columnName), declaredField.getType());
                    if (objectValue instanceof Number) {
                        Number number = (Number) objectValue;
                        String typeName = declaredField.getType().getName();
                        if ("int".equals(typeName) || "java.lang.Integer".equals(typeName)) {
                            method.invoke(o, number.intValue());
                        } else if ("short".equals(typeName) || "java.lang.Short".equals(typeName)) {
                            method.invoke(o, number.shortValue());
                        } else if ("byte".equals(typeName) || "java.lang.Byte".equals(typeName)) {
                            method.invoke(o, number.byteValue());
                        }else if ("long".equals(typeName) || "java.lang.Long".equals(typeName)) {
                            method.invoke(o, number.longValue());
                        }else if ("float".equals(typeName) || "java.lang.Float".equals(typeName)) {
                            method.invoke(o, number.floatValue());
                        }else if ("double".equals(typeName) || "java.lang.Double".equals(typeName)) {
                            method.invoke(o, number.doubleValue());
                        }
                    } else {
                        method.invoke(o, objectValue);
                    }
                }
                list.add(o);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(pstmt, connection, resultSet);
        }

        return list;

    }

    public String getSetName(String name) {
        return "set" + name.substring(0,1).toUpperCase() + name.substring(1);
    }
}
