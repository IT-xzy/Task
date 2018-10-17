package com.ptteng.dao;

import com.ptteng.entity.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassifyDao {

    List<Classify> findPageClassify(@Param("pageStart") Integer pageStart, @Param("size") Integer size, @Param("keyword") String keyword, @Param("collectionId") Long collectionId);

    long countClassify();

    Classify findById(long id);

    Boolean deleteById(long id);

    Boolean updateClassify(Classify classify);

    long insertClassify(Classify classify);

}
