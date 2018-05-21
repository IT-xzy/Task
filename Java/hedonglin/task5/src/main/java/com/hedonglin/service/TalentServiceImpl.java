package com.hedonglin.service;

import com.hedonglin.dao.TalentDao;
import com.hedonglin.model.Talent;
import com.hedonglin.util.DesUtil;
import com.hedonglin.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "talentServiceImpl")
public class TalentServiceImpl implements TalentService {

    @Resource
    private TalentDao talentDao;

    public int deleteByPrimaryKey(Long id){
        return talentDao.deleteByPrimaryKey(id);
    }

    public int insert(Talent talent){
        return talentDao.insert(talent);
    }

    public int insertSelective(Talent talent){
        return 0;
    }

    public Talent selectByPrimaryKey(Long id){
        return talentDao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Talent talent){
        return 0;
    }

    public int updateByPrimaryKeyWithBLOBs(Talent talent){
        return 0;
    }

    public int updateByPrimaryKey(Talent talent){
        return talentDao.updateByPrimaryKey(talent);
    }

    public List<Talent> randomSelectTalent(){
        return talentDao.randomSelectTalent();
    }

    public Long selectIdByName(String name){
        return talentDao.selectIdByName(name);
    }

    public Talent selectByName(String name) {
        return talentDao.selectByName(name);
    }

    public String getTokenByName(String account) throws Exception {
        Long longId=talentDao.selectIdByName(account);
        Long longTime=System.currentTimeMillis();
        String s = longId+","+longTime;
        DesUtil des=new DesUtil();
        String token = des.encrypt(s);
        return token;

    }

}
