package com.fys.music.service;

import com.fys.music.model.SystemLog;

/**
 * 记录日志的接口
 */
public interface LogService {
    void save(SystemLog systemLog);
}
