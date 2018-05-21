package com.hedonglin.service;

import com.hedonglin.dao.TalentDao;
import com.hedonglin.model.Talent;
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
}
