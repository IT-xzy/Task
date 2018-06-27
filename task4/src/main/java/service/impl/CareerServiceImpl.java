package service.impl;

import dao.CareerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Career;
import service.CareerService;

import java.util.List;

public class CareerServiceImpl implements CareerService {
    @Autowired
    CareerMapper careerMapper;
    @Override
    public Career getCareerById(int id) throws Exception {
        return careerMapper.getCareerById(id);
    }

    @Override
    public List<Career> getAllCareer() throws Exception {
        return careerMapper.getAllCareer();
    }
}
