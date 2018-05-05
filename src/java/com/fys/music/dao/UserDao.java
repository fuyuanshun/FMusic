package com.fys.music.dao;

import com.fys.music.model.Resource;
import com.fys.music.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository("userDao")
public interface UserDao {

    /**
     * 注册用户，往数据库插入一条信息
     * @param user
     */
    void insertUser(User user);


    /**
     * 通过用户名查询用户是否存在
     */
    String selectByUsername(String username);

    /**
     * 通过用户名查询密码
     */
    String selectPasswordByUsername(String username);


    /**
     * 根据用户名查询用户的状态
     */
    Integer selectState(String username);

    /**
     * 根据url查询用户
     */
    User selectByUrl(String url);

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
    List<Resource> selectResourceByPage(@Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * 更新找回密码的validateCode
     */
    void updateValidateCode(String validateCode);

    /**
     * 查询找回密码的validateCode
     */
    String selectValidateCode(String email);

    /**
     * 更新找回密码的过期时间
     */
    void updateOutDate(Date outDate);

    /**
     * 查询找回密码的过期时间
     */
    String selectOutDate(String validateCode);

    /**
     * 通过用户名修改密码
     */
    void updatePassword(@Param("username")String username, @Param("password")String password);

    /**
     * 通过email查询用户名
     */
    String selectUsernameByEmail(String email);
}
