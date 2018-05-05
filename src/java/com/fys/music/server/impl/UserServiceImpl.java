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

    /**
     * 注册用户的处理
     * @param user
     * @return
     */
    @Override
    public User registerDeal(User user) {
        String url = UUID.randomUUID().toString();
        url = url.replace("-", "");
        user.setState(0);
        user.setUrl(url);
        try {
            MailUtil.sendTo("<a href='127.0.0.1:8080/FMusic/mailConf.action?url=" + url + "'>激活帐号</a> 如果无法跳转，请将链接复制到浏览器: <a href='127.0.0.1:8080/FMusic/mailConf.action?url='"+url+">127.0.0.1:8080/FMusic/mailConf.action?url="+url+"</a>", user.getEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
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
}