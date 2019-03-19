package com.fys.music.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PowerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获得用户当前访问的页面
        String uri = request.getRequestURI();
        //判断是否是resource页面。如果是，则进行拦截
        if (uri.indexOf("resource.action") > 0) {
            HttpSession session = request.getSession();
            //如果用户名不是88888888，则进行拦截
            if(!session.getAttribute("username").equals("88888888")) {
                response.getWriter().write("您没有足够的权限访问此页面!");
                return false;
            } else {
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}