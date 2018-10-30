package com.jnshu.service.impl;

import com.jnshu.mapper.ShowreelTwoDao;
import com.jnshu.model.ShowreelTwo;
import com.jnshu.service.ShowreelTwoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ShowreelTwoServiceImpl implements ShowreelTwoService {
    @Resource
    private ShowreelTwoDao showreelTwoDao;


    @Override
    public long addShowreelTow(ShowreelTwo showreelTwo) {
        return showreelTwoDao.addShowreelTow(showreelTwo);
    }

    @Override
    public boolean deleteShowreelTow(long id) {
        return showreelTwoDao.deleteShowreelTow(id);
    }

    @Override
    public boolean updateShowreelTow(ShowreelTwo showreelTwo) {
        return showreelTwoDao.updateShowreelTow(showreelTwo);
    }

    @Override
    public ShowreelTwo findByShowreelTow(long id) {
        return showreelTwoDao.findByShowreelTow(id);
    }

    @Override
    public List<ShowreelTwo> findAllShowreelTow() {
        return showreelTwoDao.findAllShowreelTow();
    }
}
