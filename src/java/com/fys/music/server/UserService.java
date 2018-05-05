package com.fys.music.server;

import com.fys.music.model.Resource;
import com.fys.music.model.User;

import java.util.List;

public interface UserService {
    /**
     * 注册用户，往数据库插入一条信息
     * @param user
     */
    void insertUser(User user);

    /**
     * 通过用户名查询数据库是否有此数据
     */
    String selectByUsername(String username);


    /**
     * 通过用户名查询密码
     */
    String selectPasswordByUsername(String username);


    /**
     * 根据url查询用户
     */
    User selectByUrl(String url);

    /**
     * 判断用户是否已经激活
     */
    User registerDeal(User user);

    /**
     * 更新用户的状态
     */
    void mailConf(String url);

    /**
     * 根据用户名查询用户的状态
     */
    Integer selectState(String username);

    /**
     * 激活用户
     */
    void updateState(String url);

    /**
     * 查询邮箱是否已经被使用
     */
    String selectMailIsExist(String mail);

    /**
     * 查询所有的磁力链
     */
    List<Resource> selectResource();

    /**
     * 分页查询磁力链
     */
    List<Resource> selectResourceByPage(int currentPage, int pageSize);
}
