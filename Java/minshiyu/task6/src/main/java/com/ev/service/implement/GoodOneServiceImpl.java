package com.ev.service.implement;

import com.ev.DAO.GoodOneDAO;
import com.ev.cache.GoodOneCache;
import com.ev.entity.GoodOne;
import com.ev.service.GoodOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodOneServiceImpl implements GoodOneService {

    @Autowired
    private GoodOneCache goodOneCache;

    @Autowired
    private GoodOneDAO goodOneDAO;

    @Override
    public List<GoodOne> selectGoodOne() throws Exception {
        Long[] ids = {1L, 2L, 3L, 4L};
        GoodOne goodOne;
        List<GoodOne> goodOnes = new ArrayList<>();
        for (Long id : ids) {
            goodOne = goodOneCache.get(id);
            goodOnes.add(goodOne);
        }
        return goodOnes;
    }

    @Override
    public Long addGoodOne(GoodOne goodOne) throws Exception {
        goodOne.setCreateAt(System.currentTimeMillis());
        return goodOneDAO.addGoodOne(goodOne);
    }
}
