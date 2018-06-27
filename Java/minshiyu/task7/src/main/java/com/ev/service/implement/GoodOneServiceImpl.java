package com.ev.service.implement;

import com.ev.DAO.GoodOneDAO;
import com.ev.entity.GoodOne;
import com.ev.manager.GoodOneCache;
import com.ev.manager.RedisCache;
import com.ev.service.GoodOneService;
import com.ev.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodOneServiceImpl implements GoodOneService {

    @Autowired
    private GoodOneDAO goodOneDAO;

    @Autowired
    GoodOneCache goodOneCache;

    @Override
    public List<GoodOne> selectGoodOne() throws Exception {
        List<GoodOne> goodOnes = new ArrayList<>();
        GoodOne goodOne;
        for(long l=1L;l<5L;l++){
            goodOne= goodOneCache.get(l);
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
