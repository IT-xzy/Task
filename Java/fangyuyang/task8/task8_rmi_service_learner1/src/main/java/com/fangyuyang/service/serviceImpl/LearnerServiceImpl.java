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
    public void addLearner(Learner learner){
        if(learner!=null){
            System.out.println("----------------进入save-------------------");
            System.out.println("------名字----------"+learner.getName()+"-------------------");
            System.out.println("-------性别---------"+learner.getCourse()+"-------------------");
            learnerMapper.insert(learner);
            System.out.println(learnerMapper.selectByName(learner.getName()));
        }
    }
    public void updateLearner(Learner Learner){
        System.out.println("----------------进入save-------------------");
        learnerMapper.updateByPrimaryKeySelective(Learner);
    }
    public void deleteLearner(int id){
        System.out.println("----------------deletelearner-------------------");
        learnerMapper.deleteByPrimaryKey(id);
    }

    public int countAll() {
        System.out.println("----------------countall-------------------");
        return learnerMapper.countAll();
    }

    public Learner findLearnerById(int id)
    {
        System.out.println("----------------findid-------------------"+id);
        System.out.println(learnerMapper.selectByPrimaryKey(id));
        return learnerMapper.selectByPrimaryKey(id);
    }
   public Learner findByName(String name){
       System.out.println("----------------findname-------------------");
        return learnerMapper.selectByName(name);}

}
