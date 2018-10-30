package com.jnshu.service.impl;

import com.jnshu.mapper.StudioDao;
import com.jnshu.model.Studio;
import com.jnshu.service.StudioService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StudioServiceImpl implements StudioService {
    @Resource
    private StudioDao studioDao;

    @Override
    public long addStudio(Studio studio) {
        return studioDao.addStudio(studio);
    }

    @Override
    public boolean deleteStudio(long id) {
        return studioDao.deleteStudio(id);
    }

    @Override
    public boolean updateStudio(Studio studio) {
        return studioDao.updateStudio(studio);
    }

    @Override
    public Studio findByStudio(long id) {
        return studioDao.findByStudio(id);
    }

    @Override
    public List<Studio> findAllStudio() {
        return studioDao.findAllStudio();
    }
}
