package com.fys.music.controller;

import com.fys.music.model.Resource;
import com.fys.music.model.User;
import com.fys.music.server.UserService;
import com.fys.util.MailUtil;
import com.fys.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;
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
        String isexist = userService.selectByUsername(username);
        String mail = userService.selectMailIsExist(email);
        if(null == isexist) {
            if(null != mail) {
                return "registerfail";
            }
            /**
             * 后台对数据的验证,保证值不为空才发送至后台
             */
            if(password.equals(password2) && null != email && null != sex && null != age && null != birthday && null != hobby && null != phone && null != address) {
                User user = new User(username, password, email, sex, age, phone, birthday, hobby, address);
                userService.registerDeal(user);
                userService.insertUser(user);
                return "registersuccess";
            }
            return "error";
        } else {
            return "error";
        }
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
        if(null != password && null != username) {
            String dbpassword = userService.selectPasswordByUsername(username);
            Integer state = userService.selectState(username);

            if(null != state && state == 0) {
                return "loginfail";
            }

            if(password.equals(dbpassword)) {
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("username", username);
                return "loginsuccess";
            } else {
                return "loginerror";
            }
        } else return "loginerror";
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

        String url = UUID.randomUUID().toString();
        System.out.println(url);
        String email = req.getParameter("email");
        try {
            MailUtil.sendTo("<a href='localhost:8080/FMusic/forgetPassword.action?url='"+url+">请点击修改密码</a>", email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forgetpassworddeal";
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