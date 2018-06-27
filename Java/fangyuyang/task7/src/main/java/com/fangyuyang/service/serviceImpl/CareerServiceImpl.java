package com.fangyuyang.service.serviceImpl;

import com.fangyuyang.dao.CareerMapper;
import com.fangyuyang.model.Career;
import com.fangyuyang.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerServiceImpl implements CareerService {
    @Autowired
    private CareerMapper careerMapper;
    public void addCareer(Career career){
        careerMapper.insert(career);
    }
   public void updateCareer(Career career){
        careerMapper.updateByLearningMan(career);
    }
   public void deleteCareer(int id){
         careerMapper.deleteByPrimaryKey(id);
   }
   public Career findCareerById(int id){
        return careerMapper.selectByPrimaryKey(id);
   }

   public List<Career> findAll(){
        return careerMapper.list();
   }
    public int[] findCareer() {
        int[] career = new int[9];
        career[0] = careerMapper.countCareer1();
        career[1] = careerMapper.countCareer2();
        career[2] = careerMapper.countCareer3();
        career[3] = careerMapper.countCareer4();
        career[4] = careerMapper.countCareer5();
        career[5] = careerMapper.countCareer6();
        career[6] = careerMapper.countCareer7();
        career[7] = careerMapper.countCareer8();
        career[8] = careerMapper.countCareer9();
        return career;

    }
}
