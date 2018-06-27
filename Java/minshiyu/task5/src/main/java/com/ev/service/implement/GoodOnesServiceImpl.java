package com.ev.service.implement;

import com.ev.dao.GoodOnesDAO;
import com.ev.entity.GoodOne;
import com.ev.service.GoodOnesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodOnesServiceImpl implements GoodOnesService {

    @Autowired
    GoodOnesDAO goodOnesDAO;

    @Override
    public List<GoodOne> selectGoodOnes() throws Exception {
        return goodOnesDAO.findGoodOnes();
    }
}
