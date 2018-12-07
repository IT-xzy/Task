package jnshu.service.impl;

import jnshu.dao.ProfessionMapper;
import jnshu.model.Profession;
import jnshu.service.ProfessionService;
import jnshu.tool.redis.RedisTakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class ProfessionServiceImpl implements ProfessionService{

    @Autowired
    ProfessionMapper professionMapper;

    @Autowired
    RedisTakes redisTakes;

    @Override
    public int insert(Profession record) {
        return professionMapper.insert (record);
    }

    /**
     *
     * @return职业信息
     */
    @Override
    public List selectProfession() {
        List<Profession> list=(List<Profession>) redisTakes.getObj ("profession", "web");
        if (list==null ){
            List w= professionMapper.selectProfession ();
            redisTakes.addObj ("profession", "web", w);
            return w;
        }
        return list;
    }
}
