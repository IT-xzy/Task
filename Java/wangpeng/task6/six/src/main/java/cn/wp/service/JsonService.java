package cn.wp.service;

import cn.wp.entity.Json;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/1 9:48 @Version: 1.0 */
public interface JsonService {
  boolean insert(Json json);

  boolean deleteByPrimaryKey(Long id);

  boolean update(Json json);

  Json selectByPrimaryKey(Long id);

  List<Json> selectAll();

  List<Long> selectAllIds();

  List<Json> selectByIdList(List<Long> ids);
}
