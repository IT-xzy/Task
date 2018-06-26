package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.dao.LearnerMapper;
import com.fangyuyang.model.Learner;
import com.fangyuyang.service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LearnerServiceImpl implements LearnerService {
    @Autowired
    private LearnerMapper learnerMapper;
    public void addLearner(Learner Learner){
        learnerMapper.insert(Learner);
    }
    public void updateLearner(Learner Learner){
        learnerMapper.updateByPrimaryKeySelective(Learner);
    }
    public void deleteLearner(int id){
        learnerMapper.deleteByPrimaryKey(id);
    }

    public int countAll() {
        return learnerMapper.countAll();
    }

    public Learner findLearnerById(int id){
        return learnerMapper.selectByPrimaryKey(id);
    }
   public Learner findByName(String name){ return learnerMapper.selectByName(name);}

}
