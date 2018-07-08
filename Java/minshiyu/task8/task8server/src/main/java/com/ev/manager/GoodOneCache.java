package com.ev.manager;

import com.ev.DAO.GoodOneDAO;
import com.ev.entity.GoodOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoodOneCache {

    @Autowired
    RedisCache redisCache;

    @Autowired
    GoodOneDAO goodOneDAO;

    public GoodOne get(Long id) throws Exception {
        GoodOne goodOne;
//        try {
            goodOne = (GoodOne) redisCache.getHash("goodOne", id.toString());
            if (goodOne==null) {
                goodOne = goodOneDAO.findById(id);
                redisCache.setHash("goodOne", id.toString(), goodOne);
            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            goodOne = goodOneDAO.findById(id);
//        }
        return goodOne;
    }
}
