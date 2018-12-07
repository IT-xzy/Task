package jnshu.service.impl;

import jnshu.dao.ProfessionMapper;
import jnshu.model.Profession;
import jnshu.service.ProfessionService;
import jnshu.tool.memcache.MemcacheUtil;
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
    MemcacheUtil memcacheUtil;

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
        List<Profession> list =(List<Profession>) memcacheUtil.getMemcache ("profession");
        if (list!=null && !list.isEmpty ()){
            return list;
        }
            List w= professionMapper.selectProfession ();
        if (w!=null){
            memcacheUtil.saveMemcache ("profession", 0, w);}
            return w;
        }
}
