package com.ptteng.service.ServiceImpl;

import com.ptteng.CahcheUtil.CacheDao;
import com.ptteng.dao.ProfessionDao;
import com.ptteng.entity.Profession;
import com.ptteng.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    static Logger logger = Logger.getLogger(ProfessionServiceImpl.class);

    @Autowired
    private ProfessionDao professionDao;

    @Autowired
    @Qualifier("MemCacheImpl")
    private CacheDao cacheDao;

    @Override
    public List<Profession> findProfession(Integer page, Integer size) {
        logger.info("页码是" + page + "每页条数" + size);
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 4;
        }
        Integer pageStart = (page - 1) * size;
        logger.info("每页的起始位置" + pageStart);
//        这里是直接往集合中加元素，所以必须要实例化，不然会报空指针。
        List<Profession> professionList = new ArrayList<>();
        Profession profession;
//        从数据库查询出这页的id序列
        List<Map<String, Object>> mapList = professionDao.findId(pageStart, size);
        System.out.println("从数据库查询的id序列" + mapList);
//        遍历id序列
        for (Map map : mapList) {
            logger.info("开始进入遍历循环");
            Long id = (Long) map.get("id");
            logger.info("id=====" + id);
            String key = String.valueOf(id) + "profession";
            profession = (Profession) cacheDao.get(key);
            logger.info("根据id从缓存中查询的数据是" + profession);
            if (profession == null) {
                profession = professionDao.findOnePro(id);
                logger.info("从数据库查询的数据是" + profession);
                Boolean flag = cacheDao.set(key, profession);
                logger.info("将数据库查询的数据放入缓存中是否成功" + flag);
            }
//            注意注意，往上看
            professionList.add(profession);
        }
        logger.info("查询所得这页所有数据" + professionList);
        return professionList;
    }

    @Override
    public Boolean updatePro(Profession profession) {
        Long id=profession.getId();
        String key=String.valueOf(id)+"profession";
        Boolean flag1 = professionDao.updatePro(profession);
//        修改数据，删除缓存中这了数据对应的缓存
        Boolean flag2 = cacheDao.delete(key);
        logger.info("修改数据后清除缓存是否成功" + flag2);
        return flag1;
    }

    @Override
    public Long insertPro(Profession profession) {
        professionDao.insertPro(profession);
        Long id=profession.getId();
        String key=String.valueOf(id)+"profession";
//        插入数据，将数据加入缓存
        Boolean flag=cacheDao.add(key,profession);
        logger.info("插入数据增加缓存" + flag);
        return id;
    }

    @Override
    public Boolean deletePro(Long id) {
        Boolean flag1 = professionDao.deletePro(id);
        String key=String.valueOf(id)+"profession";
        Boolean flag2=cacheDao.delete(key);
        logger.info("删除数据后清除缓存是否成功" + flag2);
        return flag1;
    }

    @Override
    public Profession findOnePro(Long id) {
        String key = String.valueOf(id)+"profession";
        Profession profession;
        profession = (Profession) cacheDao.get(key);
        if (profession == null) {
            profession = professionDao.findOnePro(id);
            Boolean flag = cacheDao.add(key, profession);
            logger.info("查询单条数据后将数据放入缓存" + flag);
        }
        return profession;
    }

    @Override
    public List<Profession> findAll(Integer page, Integer size) {
        logger.info("页码是" + page + "每页条数" + size);
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 4;
        }
        Integer pageStart = (page - 1) * size;
        logger.info("每页的起始位置" + pageStart);
        List<Profession> professionList;
            professionList = professionDao.findProfession(pageStart,size);
            logger.info("从数据库中取出数据"+professionList);
        return professionList;
    }


}
