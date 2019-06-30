package jnshu.Service.JsonServiceImpl;

import com.danga.MemCached.MemCachedClient;
import jnshu.Service.JsonService;
import jnshu.cache.Cached;
import jnshu.dao.JsonMapper;
import jnshu.entity.Json;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service("JsonServiceImpl")
public class JsonServiceImpl implements JsonService {
    Logger logger = Logger.getLogger(JsonServiceImpl.class);

    @Autowired
    private JsonMapper jsonMapper;

    @Resource(name="MemCache")
    Cached cached;
    @Autowired
    private MemCachedClient memCachedClient;


    @Override
    public List<Json> selectAll() {
        Object object = memCachedClient.get("json");
        List<Json> jsons = (List<Json>) object;
        logger.info("jsons==============" + jsons);
        if (jsons == null) {
            jsons = jsonMapper.selectAll();
            boolean state = memCachedClient.set("json", jsons);
            System.out.println("state===========" + state);
            logger.info("已存入缓存");
        }
        return jsons;
    }
//插入数据的时候，先在将数据放入数据库，然后将数据的的键值对中的key设置为命名+id，将数据放入
    @Override
    public boolean insert(Json user) {
        logger.info("输入user============" + user);
        boolean start = jsonMapper.insert(user);
        logger.info("是否插入数据库" + start);
        boolean sta = memCachedClient.set("json"+user.getId(), user);
        logger.info("是否插入缓存" + sta);
        return start;
    }




        @Override
        public boolean deleteByPrimaryKey (Long id){


            boolean dbState = jsonMapper.deleteByPrimaryKey(id);
            logger.info("删除数据与否===========" + dbState);
            boolean cacheState = cached.delete("" + id);
            logger.info("删除缓存与否=========" + cacheState);
            return dbState;
        }


        @Override
        public boolean updateByPrimaryKey (Json json){
            boolean dbState = jsonMapper.updateByPrimaryKey(json);
            logger.info("更新数据与否" + dbState);
            boolean cacheState = cached.set("" + json.getId(), json);
            logger.info("更新缓存与否" + cacheState);

            return dbState;
        }


        @Override
        public Json selectByPrimaryKey (Long id){
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
        public List<Long> selectAllIds () {

            return jsonMapper.selectAllIds();
        }

        /*在缓存中首先判断缓存中有没有用数据，如果没有，根据ids去数据库中查找数据，返回，并
        将查找到的数据放入缓存中(一个一个查）
         */
        @Override
        public List<Json> selectByIdList (List < Long > ids) {
            logger.info("ids==================" + ids);
            List<Json> list = (List<Json>)memCachedClient.get("user" + ids);
            logger.info("jsonList cache======" + list);
            if(list==null){
                list = jsonMapper.selectByIdList(ids);
                logger.info("DBlist" + list);
                memCachedClient.set("user" + ids,list);
                logger.info("add to cache success======");
            }
            return list;


        }


    }