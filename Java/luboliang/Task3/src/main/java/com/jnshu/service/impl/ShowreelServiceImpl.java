package com.jnshu.service.impl;

import com.jnshu.mapper.ShowreelDao;
import com.jnshu.model.ShowreelOne;
import com.jnshu.service.ShowreelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ShowreelServiceImpl implements ShowreelService {
    @Resource
    private ShowreelDao showreelDao;


    @Override
    public long addShowreelOne(ShowreelOne showreelOne) {
        return showreelDao.addShowreelOne(showreelOne);
    }

    @Override
    public boolean deleteShowreelOne(long id) {
        return showreelDao.deleteShowreelOne(id);
    }

    @Override
    public boolean updateShowreelOne(ShowreelOne showreelOne) {
        return showreelDao.updateShowreelOne(showreelOne);
    }

    @Override
    public ShowreelOne findByShowreelOne(long id) {
        return showreelDao.findByShowreelOne(id);
    }

    @Override
    public List<ShowreelOne> findAllShowreelOne() {
        return showreelDao.findAllShowreelOne();
    }
}
