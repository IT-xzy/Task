package cn.wp.service;

import cn.wp.model.CollectionManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionManageService {
    int deleteByPrimaryKey(Long id);

    int insert(CollectionManage record);

    int insertSelective(CollectionManage record);

    CollectionManage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CollectionManage record);

    int updateByPrimaryKey(CollectionManage record);

    List<CollectionManage> selectAll();

    List<CollectionManage> selectByDynamicCondition(@Param("collectionName") String name, @Param("state") Long state);
}
