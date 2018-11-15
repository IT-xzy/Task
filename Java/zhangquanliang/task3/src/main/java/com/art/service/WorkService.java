package com.art.service;

import com.art.pojo.Work;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作品管理
 * @author suger
 * @date 2018/11/4
 */
public interface WorkService {
    // 删除作品
    Boolean delete(Integer id);

    // 新增作品
    Boolean insert(Work record);

   //  查看作品列表
    List<Work> getWork(@Param("status") Boolean status, @Param("updateBy") String updateBy);

    // 查看单个作品
    Work getWork(Integer id);
    // 更新作品
    Boolean update(Work record);

}
