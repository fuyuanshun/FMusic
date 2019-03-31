package com.fys.music.dao;

import com.fys.music.model.SystemLog;
import org.springframework.stereotype.Repository;

@Repository
public interface LogDao {
    /**
     * 更新日志
     * @param systemLog 日志信息
     */
    void save(SystemLog systemLog);
}
