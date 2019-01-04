package com.xiaobo.demo.service;

import com.xiaobo.demo.dao.ProfessionMapper;
import com.xiaobo.demo.pojo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private Profession profession;
    @Autowired
    private CommonService commonService;
    @Override
    public List<Profession> selectByDevelopmentDirection(Profession profession){
        return professionMapper.selectByDevelopmentDirection(profession);
    }
    @Override
    public ArrayList createCountArrayList(List<Profession> professionList){
        ArrayList arrayList = new ArrayList();
        for(Profession professionItem:professionList){
            Integer count = commonService.countData("excellent_student","profession_name",professionItem.getProfessionName());
            arrayList.add(count);
        }
        return arrayList;
    }
}
