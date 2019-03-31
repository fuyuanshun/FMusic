package com.fys.music.aop;

import com.fys.music.model.SystemLog;
import com.fys.music.model.User;
import com.fys.music.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Aspect
@Component
public class LogBean {
    public static User u = null;

    @Autowired LogService logService;


    public static User getUser(User user){
        u = user;
        return u;
    }

    /**
     * 登录日志
     */
    @Pointcut("execution(* com.fys.music.controller..*.login*(..))")
    public void loginLogic(){}

    @AfterReturning(value = "loginLogic()", argNames = "joinPoint, object", returning = "object")
    public void after(JoinPoint joinPoint, Object object){
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        if(null == u)
            return;
        String username = u.getUsername();
        SystemLog systemLog = new SystemLog(username, "login", new Date());
        logService.save(systemLog);
    }
}
