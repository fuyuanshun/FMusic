package com.fys.music.controller;

import com.fys.music.model.User;
import com.fys.music.server.FMusicService;
import com.fys.util.CreateVerfCode;
import com.fys.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired FMusicService userService;

    /**
     * 用户填写注册信息页面
     * @return
     */
    @RequestMapping("/register")
    public String register(HttpServletRequest req) {
        req.setAttribute("flag", false);
        return "registerAndLogin";
    }

    /**
     * 用户注册处理
     */
    @RequestMapping("/registerDeal")
    @ResponseBody
    public String registerDeal(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String email = req.getParameter("email");
        String sex = req.getParameter("sex");
        Integer age = Integer.parseInt(req.getParameter("age"));
        String year = req.getParameter("year");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String birthday = year + "-" + month + "-" + day;
        String hobby = req.getParameter("hobby");
        String phone = req.getParameter("phone");
        String emailCode = req.getParameter("emailCode");
        String emailCodeWithSession = (String)req.getSession().getAttribute("emailCode");
        String address = req.getParameter("address");
        //用户填写的验证码
        String validateCode = req.getParameter("validateCode");
        //session中的验证码
        String sessionCode = (String) req.getSession().getAttribute("checkCode");

        String ret = userService.registerDeal(username, password, password2, email, sex, age, birthday, hobby, phone, address, sessionCode, validateCode, emailCode, emailCodeWithSession);
        return ret;
    }

    /**
     * 个人中心
     */
    @RequestMapping(value = "/myInfo")
    public String myInfo(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        User user = userService.getUserInfo(username);
        req.getSession().setAttribute("user", user);
        return "myInfo";
    }

    /**
     * 更新个性签名
     */
    @RequestMapping("/updateSignature")
    public @ResponseBody String updateSignature(HttpServletRequest req, HttpServletResponse resp){
        String signature = req.getParameter("signature");
        String username = req.getParameter("username");
        return userService.updateSignature(signature, username);
    }


    /**
     * 激活邮箱
     */

    @RequestMapping("/mailConf")
    public String mailConf(HttpServletRequest req, HttpServletResponse resp) {
        String url = req.getParameter("url");
        userService.mailConf(url);
        return "/registerAndLogin";
    }


    /**
     * 用户登陆页面
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest req) {
        req.setAttribute("flag", true);
        return "registerAndLogin";
    }

    /**
     * 登陆处理
     */
    @RequestMapping("/loginDeal")
    @ResponseBody()
    public String loginDeal(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String ret = userService.loginDeal(username, password);
        if (ret.equals("loginSuccess")) {
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username", username);
            httpSession.setAttribute("userId", userService.selectIdByUsername(username));
            return "loginSuccess";
        } else {
            return ret;
        }
    }

    /**
     * 退出
     */
    @RequestMapping("/logout")
    public String logout(HttpServletRequest httpServletRequest, String username, String password) {
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }


    /**
     * 找回密码页面
     */
    @RequestMapping("/forgetPassword")
    public String forgetPassword() {
        return "forgetpassword";
    }

    /**
     * 找回密码处理
     */
    @RequestMapping("/forgetPasswordDeal")
    public void forgetPasswordDeal(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String email = req.getParameter("email");
        if(null != userService.selectMailIsExist(email)) {
            userService.forgetPasswordDeal(email);
            out.print("success");
        } else {
            out.print("emailIsNotRegister");
        }

    }

    /**
     * 检查找回密码的validateCode是否正确
     */
    @RequestMapping("/resetPassword")
    public String checkValidateCode(HttpServletRequest req, HttpServletResponse resp) {
        String validateCode = req.getParameter("validateCode");
        String email = req.getParameter("email");
        String ret = userService.checkValidateCode(validateCode, email);
        if(ret.equals("resetpage")) {
            req.setAttribute("email", email);
            return ret;
        } else {
            return ret;
        }
    }

    /**
     * 修改密码
     */
    @RequestMapping("/updatePassword")
    public void updatePassword(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter out = null;
        try {
            out = resp.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String email = req.getParameter("email");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        out.print(userService.updatePassword(username, password, password2, email));
    }

    /**
     * 发送验证码至邮箱
     */
    @RequestMapping("/verfCode")
    @ResponseBody
    public String verfCode(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String isExist = userService.selectMailIsExist(email);
        if (isExist != null) {
            return "exist";
        } else {
            String emailCode = CreateVerfCode.getVerfCode();
            req.getSession().setAttribute("emailCode", emailCode);
            MailUtil.sendTo("您的验证码为：" + emailCode, email, "验证码");
            return "success";
        }
    }
}
