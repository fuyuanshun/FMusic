package com.fys.music.dao;

import com.fys.music.model.Music;
import com.fys.music.model.Resource;
import com.fys.music.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FMusicDao {
    /**
     * 注册用户，往数据库插入一条信息
     * @param user 用户信息
     */
    int insertUser(User user);


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
     * 通过用户名修改密码
     */
    void updatePassword(@Param("username") String username, @Param("password") String password);

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
    String selectCollectById(@Param("id") String id, @Param("user_id") String userId);

    /**
     * 收藏歌曲
     */
    void collectMusic(@Param("id") String id, @Param("user_id") String userId);

    /**
     * 根据用户名查询用户id
     */
    String selectIdByUsername(String username);

    /**
     * 查询用户的收藏列表
     */
    List<Music> selectAllMusic(String userId);

    /**
     * 查询用户信息
     */
    User getUserInfo(String username);

    /**
     * 更新个性签名
     * @param signature 用户输入的数据
     * @return 影响的行数
     */
    Integer updateSignature(@Param("signature") String signature, @Param("username") String username);

    /**
     * 更新最后登录的时间
     * @param username
     */
    void updateLastLoginTime(String username);

    /**
     * 取消收藏音乐
     * @param userId 用户id
     * @param id 歌曲id
     * @return
     */
    Integer deleteFav(@Param("user_id") String userId, @Param("music_id") String id);

    /**
     * 搜索音乐信息
     * @param searchContent 查询内容
     * @return
     */
    List<Music> search(String searchContent);
}
