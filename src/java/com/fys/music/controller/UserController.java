package com.fys.music.controller;

import com.fys.music.model.Resource;
import com.fys.music.server.UserService;
import com.fys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Pattern;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户填写注册信息页面
     * @return
     */
    @RequestMapping("/register.action")
    public String register() {
        return "register";
    }

    /**
     * 用户注册处理
     */
    @RequestMapping("/registerDeal.action")
    public String registerDeal(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String birthday = req.getParameter("birthday");
        String hobby = req.getParameter("hobby");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        String ret = userService.registerDeal(username, password, password2, email, sex, age, birthday, hobby, phone, address);

        return ret;
    }


    /**
     * 激活邮箱
     */

    @RequestMapping("/mailConf.action")
    public String mailConf(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getParameter("url");
        userService.mailConf(url);
        return "/login";
    }


    /**
     * 用户登陆页面
     */
    @RequestMapping("/login.action")
    public String login() {
        return "login";
    }


    /**
     * 登陆处理
     */
    @RequestMapping("/loginDeal.action")
    public String loginDeal(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String ret = userService.loginDeal(username, password);
        if (ret.equals("loginerror")) {
            return ret;
        } else if (ret.equals("loginfail")) {
            return ret;
        } else {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username);
            return ret;
        }
    }

    /**
     * 退出
     */
    @RequestMapping("/logout.action")
    public String logout(HttpServletRequest httpServletRequest, String username, String password) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.invalidate();
        return "redirect:index.jsp";
    }


    /**
     * 播放音乐
     */
    @RequestMapping("/music.action")
    public String music() {
        return "music";
    }

    /**
     * 热门音乐
     */
    @RequestMapping("/hotmusic.action")
    public String hotmusic() {
        return "hotmusic";
    }

    /**
     * 找回密码页面
     */
    @RequestMapping("/forgetPassword.action")
    public String forgetPassword() {
        return "forgetpassword";
    }

    /**
     * 找回密码处理
     */
    @RequestMapping("/forgetPasswordDeal.action")
    public String forgetPasswordDeal(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        userService.forgetPasswordDeal(email);
        return "forgetpassworddeal";
    }

    @RequestMapping("/urlCode")
    public String confirmCode(HttpServletRequest req, HttpServletResponse resp) {
        return "";
    }

    /**
     * 资源列表页面
     */
    @RequestMapping("/resource.action")
    public ModelAndView resource(HttpServletRequest res, HttpServletResponse resp) {
        String currentPageStr;
        if(null != res.getParameter("currentPage")) {
            currentPageStr = res.getParameter("currentPage");
        } else {
            currentPageStr = "1";
            res.setAttribute("currentPage", 1);
        }
        int currentPage = 1;
        if(null !=  currentPageStr && !currentPageStr.equals("")) {
            if (Pattern.matches("^[0-9]+$", currentPageStr)) {
                currentPage = Integer.parseInt(currentPageStr);
            } else {
                currentPage = 1;
            }
        }
        //所有的磁力链
        List<Resource> resources = userService.selectResource();

        Page page = new Page(resources.size(), currentPage);
        page.init();
        int pageSize = page.getPageSize();

        if(currentPage < 1) {
            currentPage = 1;
        }
        if(currentPage > page.getTotalPage()) {
            currentPage = page.getTotalPage();
        }

        //分页查询的磁力链
        List<Resource> paging = userService.selectResourceByPage(currentPage, pageSize);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("totalPage", page.getTotalPage());
        modelAndView.addObject("currentPage", currentPage);
        res.setAttribute("currentPage", currentPage);
        modelAndView.addObject("resources", paging);
        modelAndView.addObject("page1", page);
        modelAndView.setViewName("resource");
        return modelAndView;
    }

    /**
     * 分页查询
     */

}