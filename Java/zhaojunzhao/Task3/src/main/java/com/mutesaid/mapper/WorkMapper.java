package com.mutesaid.mapper;

import com.mutesaid.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WorkMapper {

    List<Work> getWorkList(@Param("name") String name,
                           @Param("status") Boolean status);

    Long getWorkId(String name);

    Work getWork(Long workId);

    void deleteWork(Long workId);

    void updateStatus(@Param("workId") Long workId,
                      @Param("status") Boolean status);

    void insert(Work work);
}
