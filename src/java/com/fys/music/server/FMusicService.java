package com.fys.music.server;

import com.fys.music.model.Music;
import com.fys.music.model.Resource;
import com.fys.music.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface FMusicService {
    /**
     * 注册用户，往数据库插入一条信息
     * @param user
     */
    int insertUser(User user);

    /**
     * 通过用户名查询数据库是否有此数据
     */
    String selectByUsername(String username);


    /**
     * 通过用户名查询密码
     */
    String selectPasswordByUsername(String username);

    /**
     * 判断用户是否已经激活
     */
    String registerDeal(String username, String password, String password2, String email, String sex, Integer age, String birthday, String hobby, String phone, String address, String sessionCode, String validateCode, String emailCode, String emailCodeWithSession);

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
    void forgetPasswordDeal(String email);

    /**
     * 更新找回密码的validateCode
     */
    void updateValidateCode(@Param("validateCode") String validateCode, @Param("email") String email);

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
    String updatePassword(@Param("username") String username, @Param("password") String password, @Param("password2") String password2, @Param("email") String email);

    /**
     * 通过email查询用户名
     */
    String selectUsernameByEmail(String email);

    /**
     * 根据id查询音乐信息
     */

    Music selectMusicById(String id);

    /**
     * 查询所有的歌曲
     */
    List<Music> selectMusic();

    /**
     * 根据id查询歌曲是否已经被收藏
     */
    String selectCollectById(String id, String userId);

    /**
     * 收藏歌曲
     */
    void collectMusic(String id, String userId);

    /**
     * 收藏歌曲以及逻辑处理
     * @param id
     * @return
     */
    String collect(String id, String userId);

    /**
     * 根据用户名查询用户id
     */
    String selectIdByUsername(String username);

    /**
     * 查询用户收藏的音乐列表
     * @param userId
     * @return
     */
    List<Music> selectAllMusic(String userId);

    /**
     * 查询用户信息
     */
    User getUserInfo(String username);

    /**
     * 更新个性签名
     * @param signature
     * @return
     */
    String updateSignature(String signature, String username);

    /**
     * 取消收藏音乐
     * @param userId
     * @param id
     * @return
     */
    String deleteFav(String userId, String id);
}
