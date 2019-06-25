package cn.wp.dao;

import cn.wp.entity.Json;
import org.springframework.stereotype.Repository;

import java.util.List;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/6/1 9:47 @Version: 1.0 */
@Repository
public interface JsonDao {

  boolean insert(Json json);

  boolean deleteByPrimaryKey(Long id);

  boolean update(Json json);

  Json selectByPrimaryKey(Long id);

  List<Long> selectAllIds();

  List<Json> selectAll();

  List<Json> selectByIdList(List<Long> ids);
}
