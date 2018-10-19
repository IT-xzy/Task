package service.Impl;

import domain.dao.ProfMapper;
import domain.entity.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProfService;

@Service
public class ProfServiceImpl implements ProfService {

    @Autowired
    private ProfMapper mapper;


    //根据名称查询职业信息
    public Prof getByProf(String profession){
        Prof prof = mapper.getByProf(profession);
        return  prof;
    }



}
