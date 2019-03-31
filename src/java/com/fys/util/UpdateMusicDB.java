package com.fys.util;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 先执行此方法，再执行UpdateMusicList将数据库内容写入到json文件.
 * 读取电脑中的音乐，并将音乐添加到数据库中,但是需要自己手动将文件里的音乐添加到服务器中
 */
public class UpdateMusicDB {
    private static String dbName = "fmusic";
    private static String username = "root";
    private static String password = "root";

    public static void main(String[] args) {
        String pattern = "(^\\S{2,3})\\-|(^[a-zA-Z]+)\\-";
        Pattern pattern1 = Pattern.compile(pattern);

        String dirName = "E:\\CloudMusic";
        String path = "http://139.199.198.151:8080/repo/music/";
        List<String> musicList = getMusicList(dirName);
        for (String musicName : musicList) {
            Matcher matcher = pattern1.matcher(musicName);

            if (matcher.find()) {
                if (null != matcher.group(1)) {
                    insertMusic(musicName, matcher.group(1), path+musicName);
                } else if(null != matcher.group(2)){
                    insertMusic(musicName, matcher.group(2),path+musicName);
                } else {
                    insertMusic(musicName, "-", path+musicName);
                }
            }
        }
    }

    /**
     * 获得文件夹下的音乐列表,可以遍历文件夹.
     * @param dirName
     * @return
     */
    private static List<String> getMusicList(String dirName) {
        List<String> musicList = new ArrayList<>();
        File file = new File(dirName);
        String str = "";
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                //递归调用， 如果目标文件夹下有文件夹，继续进行遍历
                List<String> list = getMusicList(f.getPath());
                for (String l : list) {
                    musicList.add(l);
                }
            }
        } else {
            //获得文件的名字，并且将空格全部替换为_
            str = file.getPath().replaceAll(" ", "");
            //将原来的文件名称修改为替换后的文件名
            file.renameTo(new File(str));
            //新生成的文件
            File newFile = new File(str);
            musicList.add(newFile.getName());
        }
        return musicList;
    }

    private static void insertMusic(String musicName, String author, String path) {

        String sql = "insert into music (name, author, path) values (?, ?, ?)";

        Connection connection = MysqlUtil.getConn(dbName, username, password);
        PreparedStatement preparedStatement = MysqlUtil.getPreparedStatement(connection, sql);
        try {
            preparedStatement.setString(1, musicName);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, path);
            if (preparedStatement.execute()) {
                System.out.println(preparedStatement.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(preparedStatement.toString());
    }
}