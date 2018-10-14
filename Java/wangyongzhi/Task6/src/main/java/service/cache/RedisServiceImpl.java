package service.cache;


import domain.entity.Prof;
import domain.entity.StuInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProfService;
import service.StuInfoService;
import service.cache.util.RedisUtil;

/**
 * @Description: redis实现逻辑
 */
@Service
public class RedisServiceImpl implements CacheService {

    public static Logger logger = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Autowired(required = false)
    StuInfoService stuInfoService;
    @Autowired(required = false)
    RedisUtil redisUtil;
    @Autowired(required = false)
    ProfService profService;

    @Override
    public StuInfo get(StuInfo stuInfo){

        //根据id，组合键的值
        String key = "stu_" + stuInfo.getId();
        //先查缓存，看是否存在，若不存在，从数据库查找数据，并存入缓存
        if(redisUtil.getCacheObject(key) == null){
            stuInfo = stuInfoService.getById(stuInfo);
            redisUtil.setCacheObject(key, stuInfo);
            logger.info(key + "已经存入缓存");
            return stuInfo;
        }
        //直接取出缓存
        else{
            logger.info(key + "已经取出缓存");
            stuInfo = (StuInfo) redisUtil.getCacheObject(key);
            return stuInfo;
        }
    }

    @Override
    public Integer getCount(StuInfo stuInfo){

        int count = 0;

        //根据id，组合键的值
        String key = stuInfo.getStatus();

        //先查缓存，看是否存在，若不存在，从数据库查找数据，并存入缓存
        if(redisUtil.getCacheObject(key) == null){
            count = stuInfoService.selectStudyWork(stuInfo);
            redisUtil.setCacheObject(key, count);
            logger.info(key + "已经存入缓存");
            return count;
        }
        //直接取出缓存
        else{
            logger.info(key + "已经取出缓存");
            count = (Integer) redisUtil.getCacheObject(key);
            return count;
        }
    }

    @Override
    public Prof get(String profession){
        Prof prof;
        String key = "prof";
        //先查缓存，看是否存在，若不存在，从数据库查找数据，并存入缓存
        if(redisUtil.getCacheObject(key) == null){
            prof = profService.getByProf(profession);
            redisUtil.setCacheObject(key, prof);
            logger.info(key + "已经存入缓存");
            return prof;
        }
        //直接取出缓存
        else{
            logger.info(key + "已经取出缓存");
            prof = (Prof) redisUtil.getCacheObject(key);
            return prof;
        }
    }



}
