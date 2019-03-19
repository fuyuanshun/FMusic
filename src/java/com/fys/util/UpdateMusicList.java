package com.fys.util;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * 先执行UpdateMusicDB将音乐列表插入数据库，然后再执行此方法
 * 将数据库的音乐读取到json文件中
 */
public class UpdateMusicList {
    static String dbName = "fmusic";
    static String username = "root";
    static String password = "root";

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String filename = path + "\\src\\main\\resources\\static\\json\\list.json";
        Map<String, String> musics = queryMusicList();
        writeToFile(musics, filename);

        MysqlUtil.close();
    }

    private static void writeToFile(Map<String, String> music, String fileName) {
        Set<String> keys =  music.keySet();
        File file = new File(fileName);
        FileWriter fileWriter = null;
        StringBuffer fileContent = new StringBuffer();
        fileContent.append("[\r\n");
        try {
            fileWriter = new FileWriter(file);
            for (String key : keys) {
                String path = music.get(key);
                fileContent.append( "{\r\n\"title\":\""+ key +"\", \"mp3\":\""+ path +"\"\r\n},\r\n");
            }
            fileContent = fileContent.delete(fileContent.length()-3, fileContent.length()-2);
            fileContent = fileContent.append("\r\n]");
            fileWriter.write(fileContent.toString());
            System.out.println("写出成功! 路径为:" + file.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fileWriter) {
                    fileWriter.close();
                }
            } catch (IOException e) {

            }
        }
    }

    private static Map<String, String> queryMusicList() {
        Map<String, String> hashMap = new HashMap<>();
        ResultSet resultSet = null;
        String sql = "select * from music";
        Connection connection = MysqlUtil.getConn(dbName, username, password);
        PreparedStatement preparedStatement = MysqlUtil.getPreparedStatement(connection, sql);
        try {
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String path = resultSet.getString("path");
                hashMap.put(name, path);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            //如果连接不为空，则关闭连接
        } finally {
            try {
                if (null != resultSet) {
                    resultSet.close();
                }
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
        return hashMap;
    }
}