package com.jnshu.service.Impl;
import com.jnshu.dao.ChecksDao;
import com.jnshu.model.Checks;
import com.jnshu.service.ChecksService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChecksServiceImpl implements ChecksService {
    private Logger logger = Logger.getLogger(ChecksServiceImpl.class);
    @Resource
    private ChecksDao checksDao;

    @Override
    public int insert(Checks record) {
        int result = checksDao.insert(record);
        return result;
    }

    @Override
    public int countByPhone(String tel) {
        int result = checksDao.countByPhone(tel);
        return result;
    }

    @Override
    public Checks selectByPhone(String tel) {
        Checks checks = checksDao.selectByPhone(tel);
        return checks;
    }

    @Override
    public int countByEmail(String email) {

        return checksDao.countByEmail(email);
    }
    @Override
    public Checks selectByEmail(String email) {
        Checks checks = checksDao.selectByEmail(email);
        return checks;
    }
}
