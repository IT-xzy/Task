package cn.wp.service.impl;

import cn.wp.cache.Cached;
import cn.wp.dao.JsonDao;
import cn.wp.entity.Json;
import cn.wp.service.JsonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/1 9:49 @Version: 1.0 */
@Service("JsonService")
public class JsonServiceImpl implements JsonService {

  Logger logger = Logger.getLogger(JsonServiceImpl.class);

  @Autowired JsonDao jsonDao;

  @Autowired
  @Qualifier("Redis")
  Cached cached;

  @Override
  public boolean insert(Json json) {
    boolean dbState = jsonDao.insert(json);
    logger.info("插入数据库成功与否==========" + dbState);
    boolean cacheState = cached.set("insert" + json.getId(), json);
    logger.info("插入缓存成功与否=======" + cacheState);
    return dbState;
  }

  @Override
  public boolean deleteByPrimaryKey(Long id) {
    boolean dbState = jsonDao.deleteByPrimaryKey(id);
    logger.info("删除数据与否===========" + dbState);
    boolean cacheState = cached.delete("delete" + id);
    logger.info("删除缓存与否=========" + cacheState);
    return dbState;
  }

  @Override
  public boolean update(Json json) {
    boolean dbState = jsonDao.update(json);
    logger.info("更新数据与否" + dbState);
    boolean cacheState = cached.set("update" + json.getId(), json);
    logger.info("更新缓存与否" + cacheState);
    return dbState;
  }

    @Override
    public Json selectByPrimaryKey(Long id) {
        logger.info("id=================is" + id);
        Json json = (Json) cached.get("" + id);
        logger.info("json id = ============" + json);
        logger.info("缓存是==========" + json);
        if (ObjectUtils.isEmpty(json)) {
            json = jsonDao.selectByPrimaryKey(id);

            boolean state = cached.set("" + id, json);
            logger.info("缓存插入与否" + state);
        }
        return json;
    }

  @Override
  public List<Json> selectAll() {
    return jsonDao.selectAll();
  }

  @Override
  public List<Long> selectAllIds() {
    return jsonDao.selectAllIds();
  }

  @Override
  public List<Json> selectByIdList(List<Long> ids) {

    logger.info("进来这里没有？" + ids);
    List<Json> jsonList = (List<Json>) cached.get("" + ids);
    logger.info("缓存是==============" + jsonList);

    if (ObjectUtils.isEmpty(cached.get("" + ids))) {
      logger.info("没有缓存");
      jsonList = jsonDao.selectByIdList(ids);
      logger.info("jsonList   is============" + jsonList);
      Boolean state = cached.set("" + ids, jsonList);
      logger.info("插入成功与否？" + state);
    } else {
      logger.info("有缓存================================");
    }
    return jsonList;
  }
}

//    Logger logger = Logger.getLogger(JsonServiceImpl.class);
//
//    @Autowired private JsonDao jsonDao;
//    @Autowired private MemCachedClient memCachedClient;
//
//    @Override
//    public boolean insert(Json json) {
//        return jsonDao.insert(json);
//    }
//
//    @Override
//    public boolean deleteByPrimaryKey(Long id) {
//        return jsonDao.deleteByPrimaryKey(id);
//    }
//
//    /**
//     * @Author: wp @Description: 用replace方法，如果缓存中存在这个值的话将会更新，不存在则不进行任何操作，然后再去数据库更新信息。 @Param:
// [json]
//     *
//     * @return: boolean @Exception: @Date: 2019/6/3 14:24 // *
//     */
//    @Override
//    public boolean update(Json json) {
//        memCachedClient.replace("json", json);
//        return jsonDao.update(json);
//    }
//
//    //  @Override
//    //  public boolean update(Json json) {
//    //    return jsonDao.update(json);
//    //  }
//
//    @Override
//    public Json selectByPrimaryKey(Long id) {
//        return jsonDao.selectByPrimaryKey(id);
//    }
//
//    /**
//     * @Author: wp @Description: 从缓存中取数据，能取直接返回；取不出来从数据库中取，再放入缓存 @Param: []
//     *
//     * @return: java.util.List<cn.wp.entity.Json> @Exception: @Date: 2019/6/3 14:24
//     */
//    @Override
//    public List<Json> selectAll() {
//        Object object = memCachedClient.get("json");
//        if (object != null) {
//            logger.info("从缓存里取");
//            return (List<Json>) object;
//        } else {
//            logger.info("从数据库里取");
//            List<Json> jsons = jsonDao.selectAll();
//            boolean state = memCachedClient.set("json", jsons);
//            logger.info("设置了没有?" + state);
//            return jsons;
//        }
//    }
//
//    //  @Override
//    //  public List<Json> selectAll() {
//    //    return jsonDao.selectAll();
//    //  }
//
//    @Override
//    public List<Long> selectAllIds() {
//        return jsonDao.selectAllIds();
//    }
//
//    @Override
//    public List<Json> selectByIdList(List<Long> ids) {
//        // ids作为缓存的名字,查找缓存里有没有
//        List<Json> jsonList = (List<Json>) memCachedClient.get(ids + "");
//        logger.info("jsonList cache======" + jsonList);
//        // 如果缓存里没有ids,
//        if (memCachedClient.get(ids + "") == null
//                || CollectionUtils.isEmpty((List<Json>) memCachedClient.get(ids + ""))) {
//            logger.info("cache is null======");
//            // 用jsonList接收查出来的数据
//            jsonList = jsonDao.selectByIdList(ids);
//            logger.info("jsonList======" + jsonList);
//            // 把jsonList放入缓存
//            memCachedClient.set(ids + "", jsonList);
//            logger.info("add to cache success======");
//        } else {
//            logger.info("cache is not null======");
//        }
//        return jsonList;
