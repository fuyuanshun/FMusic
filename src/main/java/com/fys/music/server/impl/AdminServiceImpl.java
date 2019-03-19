package com.fys.music.server.impl;

import com.alibaba.fastjson.JSON;
import com.fys.music.dao.AdminDao;
import com.fys.music.server.AdminService;
import com.fys.util.MD5Util;
import com.fys.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Override
    public String uploadMusic(MultipartFile multipartFile, HttpServletRequest req) {
        String fileName = multipartFile.getOriginalFilename();
        ResultUtil resultUtil = null;
        if (fileName == null || "".equals(fileName) || fileName.split("\\.").length == 0) {
            resultUtil = new ResultUtil("400", "仅支持上传MP3文件", null);
            return JSON.toJSONString(resultUtil);
        }


        if (!fileName.split("\\.")[fileName.split("\\.").length-1].equals("mp3")) {
            resultUtil = new ResultUtil("400", "仅支持上传MP3文件", null);
            return JSON.toJSONString(resultUtil);
        }

        String path = req.getServletContext().getRealPath("/music");
        File uploadDir = new File(path+"/"+fileName);
        try {
            if (!new File(path).exists()) {
                new File(path).mkdirs();
            }
            uploadDir.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream stream = null;
        try {
            fileOutputStream = new FileOutputStream(uploadDir);
            byte[] bytes = multipartFile.getBytes();
            stream = new BufferedOutputStream(
                    fileOutputStream);
            stream.write(bytes);
            stream.flush();
        } catch (FileNotFoundException e) {
            System.out.println("path error!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        resultUtil = new ResultUtil("200", "上传成功", null);
        return JSON.toJSONString(resultUtil);
    }

    /**
     * 查询音乐是否已经存在
     * @param musicName 音乐名称
     * @return
     */
    @Override
    public int musicIsExist(String musicName) {
        return adminDao.musicIsExist(musicName);
    }

    /**
     * 添加音乐到数据库
     * @param name 音乐名称
     * @param author 演唱者
     * @param path 音乐路径
     */
    @Override
    public void addMusic(String name, String author, String path) {
       adminDao.addMusic(name, author, path);
    }

    /**
     * 查询管理员信息
     * @param username 管理员账号
     * @param password 管理员密码
     * @return
     */
    @Override
    public String getAdminInfo(String username, String password, HttpServletRequest req) {
        //数据库的密码为加密后的密码，所以先将密码进行加密，再进行查询
        password = MD5Util.getMD5(password);
        if (adminDao.getAdminInfo(username, password) == 1) {
            req.getSession().setAttribute("admin", username);
            return "success";
        } else {
            return "账号或密码错误!";
        }
    }
}
