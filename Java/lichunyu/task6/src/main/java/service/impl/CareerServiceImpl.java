package service.impl;

import dao.CareerMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Career;
import service.CareerService;
import utils.RedisCacheManager;
import java.util.List;
@Service
public class CareerServiceImpl implements CareerService {
    private Logger log = Logger.getLogger(CareerService.class);
    @Autowired
    RedisCacheManager redisCacheManager;
    @Autowired
    CareerMapper careerMapper;
    @Override
    public Career getCareerById(int id) throws Exception {
        Career career;
        if(redisCacheManager.get("career"+id)!=null){
            career = (Career) redisCacheManager.get("career"+id);
            log.info("Redis缓存取出");
        }else {
            career = careerMapper.getCareerById(id);
            redisCacheManager.set("career"+id,career);
            log.info("Redis缓存存入");
        }
        return career;
    }

    @Override
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<Career> getAllCareer() throws Exception {
        List<Career> list;
        if (redisCacheManager.get("allCareerList")!=null){
            list = (List<Career>) redisCacheManager.get("allCareerList");
            log.info("redisList取出缓存");
        }else {
            list = careerMapper.getAllCareer();
            redisCacheManager.set("allCareerList",list);
            log.info("redisList存入缓存");
        }
        return list;
    }
}
