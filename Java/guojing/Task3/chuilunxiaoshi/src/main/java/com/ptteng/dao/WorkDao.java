package com.ptteng.dao;

import com.ptteng.entity.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface WorkDao {
    List<Work> findPageWork(@Param("pageStart") Integer pageStart, @Param("size") Integer size, @Param("keyword")
            String keyword, @Param("classifyId") Long classifyId);

    long countWork();


    Work findById(long id);

    Boolean deleteById(long id);

    Boolean updateWork(Work work);

    long insertWork(Work work);

}
