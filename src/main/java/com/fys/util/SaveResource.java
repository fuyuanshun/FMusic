package com.fys.util;

import java.io.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 将磁力链存储到数据库，如果已经存在的磁力链不会被重复存储
 */
public class SaveResource {
    public static void main(String[] args) {
        String fileName = "F:\\资源.txt";
        readFileByLines(fileName);
    }


    /**
     * 读取文件内容，每次读取一行
     */
    private static void readFileByLines(String finaName) {
        File file = new File(finaName);
        BufferedReader bufferedReader;
        Connection connection = null;
        //正则表达式的模板
        String pattern = "magnet:\\?xt=urn:btih:[A-Z0-9]{10,60}\\s+$";
        try {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"gbk"); //指定以UTF-8编码读入
            bufferedReader = new BufferedReader(isr);
            String str;
            connection = getConnection();
            while ((str = bufferedReader.readLine()) != null) {
                str = str.replace("\\s", "");
                Pattern pattern1 = Pattern.compile(pattern);
                Matcher matcher = pattern1.matcher(str);
                while (matcher.find()) {
                    String resource = matcher.group();
                    if(!isExist(resource, connection)) {
                        System.out.println("链接已经保存! :"+resource);
                        save(resource, connection);
                    } else {
                        System.out.println("链接已经存在!");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("文件未找到！");
        } catch (IOException e) {
            System.out.println("文件读取错误！");
        } finally {
            close(connection);
        }
    }

    /**
     * 获得一个数据库连接
     */
    private static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost/fmusic", "root", "root");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 获得一个preparedStatement
     */
    private static PreparedStatement getPstmt(Connection connection, String sql) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }

    /**
     * 将磁力链存储到数据库
     * @param resource
     */
    private static void save(String resource, Connection connection) {
        PreparedStatement preparedStatement = null;
        String sql = "insert into resource (magnet) values (?)";

        try {
            preparedStatement = getPstmt(connection, sql);
            preparedStatement.setString(1, resource);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
        }
    }

    /**
     * 查询磁力链是否存在
     * @param resource
     * @return
     */
    private static boolean isExist(String resource, Connection connection) {
        PreparedStatement preparedStatement;
        String sql = "select magnet from resource where magnet = ?";

        preparedStatement = getPstmt(connection, sql);
        try {
            preparedStatement.setString(1, resource);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(preparedStatement);
        }
        return false;
    }

    /**
     * 将数据库连接清空
     */
    private static void close(Connection connection) {
        if(null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 将preparedStatement
     */
    private static void close(PreparedStatement preparedStatement) {
        if(null != preparedStatement) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}