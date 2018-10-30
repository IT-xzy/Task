package com.ptteng.service;

import com.ptteng.dao.BbsDao;
import com.ptteng.entity.Bbs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BbsService {

    @Autowired
    private BbsDao bbsDao;
    public long insertBbs(Bbs bbs) {
        bbs.setCreateAt(System.currentTimeMillis());
        bbs.setUpdateAt(System.currentTimeMillis());
        return bbsDao.insertBbs(bbs);
    }

    public List<Bbs> findMessage(Bbs bbs){
        return bbsDao.findMessage(bbs);
    }

    public Boolean updateBbs(Bbs bbs){
        return bbsDao.updateBbs(bbs);
    }

    public Boolean deleteById(long id){
        return bbsDao.deleteById(id);
    }


}
