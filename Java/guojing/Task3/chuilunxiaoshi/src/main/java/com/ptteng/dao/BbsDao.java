package com.ptteng.dao;


import com.ptteng.entity.Bbs;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BbsDao {
    long insertBbs(Bbs bbs);

    Boolean updateBbs(Bbs bbs);

    List<Bbs> findMessage(Bbs bbs);

    Boolean deleteById(long id);

}
