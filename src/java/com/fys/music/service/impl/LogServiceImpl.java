package com.fys.music.service.impl;

import com.fys.music.dao.LogDao;
import com.fys.music.model.SystemLog;
import com.fys.music.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogServiceImpl implements LogService {

    @Autowired LogDao logDao;

    @Override
    public void save(SystemLog systemLog) {
        logDao.save(systemLog);
    }
}
