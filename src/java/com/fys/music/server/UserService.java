package com.fys.music.server;

import com.fys.music.model.Resource;
import com.fys.music.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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
    String registerDeal(String username, String password, String password2, String email, String sex, Integer age, String birthday, String hobby, String phone, String address);

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
     * 用户登陆处理
     */
    String loginDeal(String username, String password);

    /**
     * 查询所有的磁力链
     */
    List<Resource> selectResource();

    /**
     * 分页查询磁力链
     */
    List<Resource> selectResourceByPage(int currentPage, int pageSize);

    /**
     * 找回密码的处理逻辑
     */
    public void forgetPasswordDeal(String email);

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
     * 检查找回密码的时间是否过期
     */
    String checkValidateCode(String validateCode, String email);

    /**
     * 通过用户名修改密码
     */
    String updatePassword(@Param("username")String username, @Param("password")String password, @Param("password2")String password2, @Param("email")String email);

    /**
     * 通过email查询用户名
     */
    String selectUsernameByEmail(String email);
}
