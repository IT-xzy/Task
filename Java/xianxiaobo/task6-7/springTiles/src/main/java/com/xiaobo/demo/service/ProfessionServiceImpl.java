package com.xiaobo.demo.service;

import com.whalin.MemCached.MemCachedClient;
import com.xiaobo.demo.dao.ProfessionMapper;
import com.xiaobo.demo.pojo.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service("ProfessionServiceImpl")
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    private ProfessionMapper professionMapper;
    @Autowired
    private Profession profession;
    @Autowired
    private CommonService commonService;
    @Autowired
    MemCachedClient memCachedClient;
//    @Override
//    public List<Profession> selectByDevelopmentDirection(Profession profession){
//        Long startTime = System.currentTimeMillis();
//        List<Profession> professionList = (List<Profession>) memCachedClient.get("professionList"+profession.getDevelopmentDirection());
//        if(professionList==null){
//            professionList = professionMapper.selectByDevelopmentDirection(profession);
//            memCachedClient.add("professionList"+profession.getDevelopmentDirection(),professionList);
//            System.out.println("没有从缓存中获取");
//
//        }else{
//            System.out.println("从缓存中获取");
//        }
//
////        List<Profession> professionList =professionMapper.selectByDevelopmentDirection(profession);
//        Long endTime = System.currentTimeMillis();
////        System.out.println("没有缓存");
//        System.out.println("花费的时间");
//        System.out.println(endTime - startTime);
//        return professionList;
//    }
//    @Cacheable("selectByDevelopmentDirection")
    @Override
    public List<Profession> selectByDevelopmentDirection(Profession profession){
        List<Profession> professionList =professionMapper.selectByDevelopmentDirection(profession);

        return professionList;
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
//    @CacheEvict(value={"selectByDevelopmentDirection"},allEntries = true)
    @Override
    public Integer insertBatch(List<Profession> professionList){
        return professionMapper.insertBatch(professionList);
    }
}
