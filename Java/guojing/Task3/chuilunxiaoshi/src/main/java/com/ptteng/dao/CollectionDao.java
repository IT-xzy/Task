package com.ptteng.dao;


import com.ptteng.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionDao {

    //    设置三个入参，keyword为非必传参数，为空时，按照page和size查询，不为空时，按keyword查询
    List<Collection> findPageCollection(@Param("pageStart") int pageStart, @Param("size") int size, @Param("keyword") String keyword);

    int countCollection();

    Collection findById(long id);

    Boolean deleteById(long id);

    Boolean updateCollection(Collection collection);

    long insertCollection(Collection collection);

}
