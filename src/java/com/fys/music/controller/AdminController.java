package com.fys.music.controller;

import com.alibaba.fastjson.JSON;
import com.fys.music.server.AdminService;
import com.fys.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired AdminService adminService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String adminIndex(HttpServletRequest req) {
        return "admin";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin() {
        return "adminLogin";
    }

    @RequestMapping("/login")
    public @ResponseBody String login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if (username.trim().equals("") || password.trim().equals("")) {
            return "不能为空";
        } else {
            return adminService.getAdminInfo(username, password, req);
        }
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest req, HttpServletResponse resp) {
        //清空Session
        req.getSession().removeAttribute("admin");
        return  "redirect:/admin/";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody String upload(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest req) {
        String fileName = multipartFile.getOriginalFilename();
        //如果歌曲已经存在了，不再进行上传操作
        if (adminService.musicIsExist(fileName) > 0) {
            ResultUtil resultUtil = new ResultUtil("400", "该歌曲已经存在！", null);
            return JSON.toJSONString(resultUtil);
        }
        //上传音乐
        String json = adminService.uploadMusic(multipartFile, req);
        ResultUtil resultUtil = JSON.parseObject(json, ResultUtil.class);
        if (resultUtil.getCode().equals("200")) {
            adminService.addMusic(fileName, "-", "139.199.198.151:8080//FMusic/music/"+fileName);
        }
        return json;
    }
}
