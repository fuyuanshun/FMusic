package com.fys.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Mysql工具
 */
public class MysqlUtil {
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;


    public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    public static Connection getConn(String dbName, String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName +"?characterEncoding=UTF-8&useSSL=false", username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (null != preparedStatement) {
                preparedStatement.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}