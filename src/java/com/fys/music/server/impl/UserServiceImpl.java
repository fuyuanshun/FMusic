package com.fys.music.server.impl;

import com.fys.music.dao.UserDao;
import com.fys.music.model.Resource;
import com.fys.music.model.User;
import com.fys.music.server.UserService;
import com.fys.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * 注册用户
     */
    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    /**
     * 通过用户名查询数据库是否有此数据
     */
    @Override
    public String selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public String selectPasswordByUsername(String username) {
        return userDao.selectPasswordByUsername(username);
    }

    @Override
    public User selectByUrl(String url) {
        return userDao.selectByUrl(url);
    }

    @Override
    public String registerDeal(String username, String password, String password2, String email, String sex, Integer age, String birthday, String hobby, String phone, String address) {
        String isexist = selectByUsername(username);
        String mail = selectMailIsExist(email);
        if(null == isexist) {
            if(null != mail) {
                return "registerfail";
            }
            /**
             * 后台对数据的验证,保证值不为空才发送至后台
             */
            if(password.equals(password2) && null != email && null != sex && null != age && null != birthday && null != hobby && null != phone && null != address) {
                User user = new User(username, password, email, sex, age, phone, birthday, hobby, address);

                String url = UUID.randomUUID().toString();
                url = url.replace("-", "");
                user.setState(0);
                user.setUrl(url);
                try {
                    MailUtil.sendTo("<a href='127.0.0.1:8080/FMusic/mailConf.action?url=" + url + "'>激活帐号</a> 如果无法跳转，请将链接复制到浏览器: <a href='127.0.0.1:8080/FMusic/mailConf.action?url='"+url+">127.0.0.1:8080/FMusic/mailConf.action?url="+url+"</a>", user.getEmail());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                insertUser(user);
                return "registersuccess";
            }
            return "error";
        } else {
            return "error";
        }
    }

    /**
     * 用户登陆处理
     */
    @Override
    public String loginDeal(String username, String password) {
        if(null != password && null != username) {
            String dbpassword = selectPasswordByUsername(username);
            Integer state = selectState(username);

            if(null != state && state == 0) {
                return "loginfail";
            }

            if(password.equals(dbpassword)) {
                return "loginsuccess";
            } else {
                return "loginerror";
            }
        } else return "loginerror";
    }

    /**
     * 调用激活用户的方法
     * @param url 用户的uuid
     */
    @Override
    public void mailConf(String url) {
        updateState(url);
    }

    /**
     * 查询用户的状态 是否激活
     * @param username 用户名
     */
    @Override
    public Integer selectState(String username) {
        return userDao.selectState(username);
    }

    /**
     * 激活用户
     * @param url
     */
    @Override
    public void updateState(String url) {
        userDao.updateState(url);
    }

    /**
     * 查询邮箱是否已经被使用
     * @param mail
     * @return
     */
    @Override
    public String selectMailIsExist(String mail) {
        return userDao.selectMailIsExist(mail);
    }

    /**
     * 查询所有的磁力链和id
     * @return
     */
    @Override
    public List<Resource> selectResource() {
        return userDao.selectResource();
    }

    /**
     * 分页查询磁力链
     * @return
     */
    @Override
    public List<Resource> selectResourceByPage(int currentPage, int pageSize) {
        currentPage = (currentPage-1)*10+1;
        return userDao.selectResourceByPage(currentPage, pageSize);
    }

    /**
     * 找回密码的处理逻辑
     */
    @Override
    public void forgetPasswordDeal(String email) {
        String url = UUID.randomUUID().toString();
        System.out.println(url);
        try {
            MailUtil.sendTo("<a href='localhost:8080/FMusic/forgetPassword.action?url='"+url+">请点击修改密码</a>", email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}