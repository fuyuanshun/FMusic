package com.fys.music.controller;

import com.alibaba.fastjson.JSON;
import com.fys.music.service.AdminService;
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
        return "admin/index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "admin/welcome";
    }


    @RequestMapping("/404")
    public String page404(){
        return "admin/404";
    }

    @RequestMapping("/_blank")
    public String _blank(){
        return "admin/_blank";
    }

    @RequestMapping("/_footer")
    public String _footer(){
        return "admin/_footer";
    }

    @RequestMapping("/_header")
    public String _header(){
        return "admin/_header";
    }

    @RequestMapping("/_menu")
    public String _menu(){
        return "admin/_menu";
    }

    @RequestMapping("/_meta")
    public String _meta(){
        return "admin/_meta";
    }

    @RequestMapping("/admin-add")
    public String admin_add(){
        return "admin/admin-add";
    }

    @RequestMapping("/admin-list")
    public String admin_list(){
        return "admin/admin-list";
    }

    @RequestMapping("/admin-password-edit")
    public String admin_password_edit(){
        return "admin/admin-password-edit";
    }


    @RequestMapping("/admin-permission")
    public String admin_permission(){
        return "admin/admin-permission";
    }

    @RequestMapping("/admin-role")
    public String admin_role(){
        return "admin/admin-role";
    }

    @RequestMapping("/admin-role-add")
    public String admin_role_add(){
        return "admin/admin-role-add";
    }

    @RequestMapping("/article-add")
    public String article_add(){
        return "admin/article-add";
    }

    @RequestMapping("/article-class")
    public String article_class(){
        return "admin/article-class";
    }



    @RequestMapping("/article-class-edit")
    public String article_class_edit(){
        return "admin/article-class-edit";
    }

    @RequestMapping("/article-list")
    public String article_list(){
        return "admin/article-list";
    }

    @RequestMapping("/change-password")
    public String change_password(){
        return "admin/change-password";
    }

    @RequestMapping("/charts-1")
    public String charts_1(){
        return "admin/charts-1";
    }

    @RequestMapping("/charts-2")
    public String charts_2(){
        return "admin/charts-2";
    }

    @RequestMapping("/charts-3")
    public String charts_3(){
        return "admin/charts-3";
    }

    @RequestMapping("/charts-4")
    public String charts_4(){
        return "admin/charts-4";
    }

    @RequestMapping("/charts-5")
    public String charts_5(){
        return "admin/charts-5";
    }

    @RequestMapping("/charts-6")
    public String charts_6(){
        return "admin/charts-6";
    }

    @RequestMapping("/charts-7")
    public String charts_7(){
        return "admin/charts-7";
    }

    @RequestMapping("/codeing")
    public String codeing(){
        return "admin/codeing";
    }

    @RequestMapping("/feedback-list")
    public String feedback_list(){
        return "admin/feedback-list";
    }

    @RequestMapping("/index-2")
    public String index_2(){
        return "admin/index-2";
    }

    @RequestMapping("/login_")
    public String login(){
        return "admin/login_";
    }

    @RequestMapping("/member-add")
    public String member_add(){
        return "admin/member-add";
    }

    @RequestMapping("/member-del")
    public String member_del(){
        return "admin/member-del";
    }

    @RequestMapping("/member-list")
    public String member_list(){
        return "admin/member-list";
    }


    @RequestMapping("/member-record-browse")
    public String member_record_browse(){
        return "admin/member-record-browse";
    }

    @RequestMapping("/member-record-download")
    public String member_record_download(){
        return "admin/member-record-download";
    }

    @RequestMapping("/member-record-share")
    public String member_record_share(){
        return "admin/member-record-share";
    }

    @RequestMapping("/member-show")
    public String member_show(){
        return "admin/member-show";
    }

    @RequestMapping("/picture-add")
    public String picture_add(){
        return "admin/picture-add";
    }

    @RequestMapping("/picture-list")
    public String picture_list(){
        return "admin/picture-list";
    }
    @RequestMapping("/product-add")
    public String product_add(){
        return "admin/product-add";
    }

    @RequestMapping("/product-brand")
    public String product_brand(){
        return "admin/product-add";
    }

    @RequestMapping("/product-category")
    public String product_category(){
        return "admin/product-category";
    }

    @RequestMapping("/product-category-add")
    public String product_category_add(){
        return "admin/product-category-add";
    }

    @RequestMapping("/product-list")
    public String product_list(){
        return "admin/product-list";
    }

    @RequestMapping("/record-browse")
    public String record_browse(){
        return "admin/record-browse";
    }

    @RequestMapping("/record-download")
    public String record_download(){
        return "admin/record-download";
    }

    @RequestMapping("/record-share")
    public String record_share(){
        return "admin/record-share";
    }

    @RequestMapping("/system-base")
    public String system_base(){
        return "admin/system-base";
    }

    @RequestMapping("/system-category")
    public String system_category(){
        return "admin/system-category";
    }

    @RequestMapping("/system-category-add")
    public String system_category_add(){
        return "admin/system-category-add";
    }

    @RequestMapping("/system-data")
    public String system_data(){
        return "admin/system-data";
    }

    @RequestMapping("/system-log")
    public String system_log(){
        return "admin/system-log";
    }

    @RequestMapping("/system-shielding")
    public String system_shielding(){
        return "admin/system-shielding";
    }

    @RequestMapping("/user-add")
    public String user_add(){
        return "admin/user-add";
    }

    @RequestMapping("/user-list")
    public String user_list(){
        return "admin/user-list";
    }

    @RequestMapping("/user-password-edit")
    public String user_password_edit(){
        return "admin/user-password-edit";
    }

    @RequestMapping("/user-show")
    public String user_show(){
        return "admin/user-show";
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
        return  "redirect:/admin/index";
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
