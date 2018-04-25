package com.fml.service.impl;

import com.alibaba.fastjson.JSON;
import com.fml.cache.VocationCache;
import com.fml.mapper.VocationMapper;
import com.fml.pojo.Vocation;
import com.fml.service.VocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VocationServiceImpl implements VocationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VocationServiceImpl.class);

    @Autowired
    VocationMapper vocationMapper;

    @Autowired
    VocationCache vocationCache;

    @Override
    public int getTotalCount() {
        if (vocationCache.get("totalCount") != null){
            LOGGER.info("缓存读取职业总数...");
            return (int)vocationCache.get("totalCount");
        }else {
            LOGGER.info("数据库读取职业总数...");
            int result = vocationMapper.getTotalCount();
            vocationCache.set("totalCount",result);
            return result;
        }
    }

    @Override
    public Vocation getByVocationId(int id) {
        return vocationMapper.getByVocationId(id);
    }

    @Override
    public List<Vocation> getAllVocation(){
        List<Vocation> list = new ArrayList<>(12);

        if (vocationCache.get("vocationList") != null){
            LOGGER.info("缓存读取所有职业信息...");
            Object object = vocationCache.get("vocationList");
            return JSON.parseArray(object.toString(),Vocation.class);
        }else{
            LOGGER.info("数据库读取职业总数...");
            for (int i = 1; i <= this.getTotalCount(); i++){
                list.add(this.getByVocationId(i));
            }
            /*先转化为json字符串*/
            String json = JSON.toJSONString(list);
            vocationCache.set("vocationList",json);
            return list;
        }
    }
}
