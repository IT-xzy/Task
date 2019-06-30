package jnshu.Service.JsonServiceImpl;

import jnshu.Service.JsonService;
import jnshu.cache.Cached;
import jnshu.dao.JsonMapper;
import jnshu.entity.Json;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import sun.misc.Cache;

import javax.annotation.Resource;
import java.util.List;

@Service("JsonServiceImp")
public class  JsonServiceImp implements JsonService {

    Logger logger = Logger.getLogger(JsonServiceImp.class);
    @Autowired
    JsonMapper jsonMapper;

    @Autowired
    RedisTemplate redisTemplate;

    @Resource(name = "Redis")
    Cached cached;





    @Override
    public boolean insert(Json json) {
        Boolean start = jsonMapper.insert(json);
        logger.info("已存入数据库" + start);
        Boolean redisStart = cached.set("task" + json.getId(), json);
        logger.info("已存入缓存" + redisStart);
        return start;
    }

    @Override
    public boolean deleteByPrimaryKey(Long id) {
        Boolean start = jsonMapper.deleteByPrimaryKey(id);
        logger.info("是否在数据库中删除" + start);
        Boolean redisStart = cached.delete("task" + id);
        logger.info("是否在缓存中删除" + redisStart);
        return start;
    }

    @Override
    public boolean updateByPrimaryKey(Json json) {
        Boolean start = jsonMapper.updateByPrimaryKey(json);
        logger.info("是否在数据库中删除" + start);
        Boolean redisStart = cached.set("task" + json.getId(), json);
        logger.info("是否在缓存中删除" + redisStart);
        return start;
    }

    @Override
    public Json selectByPrimaryKey(Long id) {
        logger.info("id=================is" + id);
        Json json = (Json) cached.get("" + id);
        logger.info("json id = ============" + json);
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
        logger.info("ids==================" + ids);
        List<Json> list = (List<Json>) cached.get("task" + ids);
        logger.info("jsonList cache======" + list);
        if (list == null) {
            list = jsonMapper.selectByIdList(ids);
            logger.info("DBlist" + list);
            cached.set("task" + ids, list);
            logger.info(cached.get("task" + ids));
        }
        return list;


    }

    @Override
    public List<Json> selectAll() {
         Object object = cached.get("json");
        List<Json> jsons = (List<Json>) object;
        logger.info("jsons==============" + jsons);
        if (jsons == null) {
            jsons = jsonMapper.selectAll();
            boolean state = cached.set("json", jsons);
            System.out.println("state===========" + state);
            logger.info("已存入缓存");
        }
        return jsons;
    }
}
