package com.fys.music.dao;

import com.fys.music.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao {

    /**
     * 查询歌曲是否已经存在
     * @param musicName
     * @return
     */
    int musicIsExist(String musicName);

    /**
     * 将音乐添加到数据库
     */
    void addMusic(@Param("name") String name, @Param("author") String author, @Param("path") String path);

    /**
     * 查询管理员是否存在
     * @param username
     * @param password
     * @return
     */
    Integer getAdminInfo(@Param("username") String username, @Param("password") String password);

    /**
     * 获取管理员所有信息
     * @param username 管理员账号
     * @return 管理员信息
     */
    User getAllInfo(String username);
}
