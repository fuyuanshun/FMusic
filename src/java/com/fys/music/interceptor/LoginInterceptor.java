package com.fys.music.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        /**
         *  放行用户的注册，登陆和处理页面
         */
        if(uri.indexOf("login.action") >= 0){
            return true;
        } else if (uri.indexOf("loginDeal.action") >= 0) {
            return true;
        } else if (uri.indexOf("register.action") >= 0) {
            return true;
        } else if (uri.indexOf("registerDeal.action") >= 0) {
            return true;
        } else if (uri.indexOf("mailConf.action") >= 0) {
            return true;
        } else if (uri.indexOf("forgetPassword.action") >= 0) {
            return true;
        } else if (uri.indexOf("forgetPasswordDeal.action") >= 0) {
            return true;
        }
        /**
         * 查看session中是否有数据
         */
        HttpSession httpSession = request.getSession();
        String username = (String)httpSession.getAttribute("username");
        if(null != username) {
            return true;
        }

        /**
         * 如果执行到这里说明需要身份验证
          */
        request.getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}