package com.ptteng.Service.JsonServiceImple;

import com.danga.MemCached.MemCachedClient;
import com.ptteng.Service.JsonService;
import com.ptteng.cache.Cached;
import com.ptteng.dao.JsonMapper;
import com.ptteng.entity.Json;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @ClassName JsonServiceImp
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/22  17:46
 * @Version 1.0
 **/
@Service
public class JsonServiceImp implements JsonService {
    Logger logger = Logger.getLogger(JsonServiceImp.class);

    @Autowired
    JsonMapper jsonMapper;

    @Autowired
    @Qualifier("Redis")
    Cached cached;

    @Override
    public boolean insert(Json json) {
        boolean dbState = jsonMapper.insert(json);
        logger.info("插入数据库成功与否==========" + dbState);
        boolean cacheState = cached.set("" + json.getId(), json);
        logger.info("插入缓存成功与否=======" + cacheState);
        return dbState;
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {


        boolean dbState = jsonMapper.deleteByPrimaryKey(id);
        logger.info("删除数据与否===========" + dbState);
        boolean cacheState = cached.delete("" + id);
        logger.info("删除缓存与否=========" + cacheState);
        return dbState;
    }


    @Override
    public boolean updateByPrimaryKey(Json json) {
        boolean dbState = jsonMapper.updateByPrimaryKey(json);
        logger.info("更新数据与否" + dbState);
        boolean cacheState = cached.set("" + json.getId(), json);
        logger.info("更新缓存与否" + cacheState);

        return dbState;
    }

    /*
     * @Author 孙若飞
     * @Description //TODO
     * @Date 12:13 2019/2/28
     * @Param [id]
     * @return int
     **/
    @Override
    public Json selectByPrimaryKey(Long id) {
        logger.info("id=================is"+id);
        Json json = (Json) cached.get("" + id);
        logger.info("json id = ============"+json);
        logger.info("缓存是==========" + json);
        if (ObjectUtils.isEmpty(json)) {
            json = jsonMapper.selectByPrimaryKey(id);
            boolean state = cached.set("" + id, json);
            logger.info("缓存插入与否" + state);
        }
        return json;
    }

    @Override
    public List<Long> selectAllIds() {

        return jsonMapper.selectAllIds();
    }

    @Override
    public List<Json> selectByIdList(List<Long> ids) {

        logger.info("进来这里没有啊" + ids);
        List<Json> jsonList = (List<Json>) cached.get("" + ids);
        logger.info("缓存是=========" + jsonList);

        if (ObjectUtils.isEmpty(cached.get("" + ids))) {
            logger.info("没有缓存");
            jsonList = jsonMapper.selectByIdList(ids);
            logger.info("jsonList   is============" + jsonList);
            Boolean state = cached.set("" + ids, jsonList);
            logger.info("插入成功与否" + state);
        } else {
            logger.info("他娘的有缓存啊!");
        }
        return jsonList;
    }


}
