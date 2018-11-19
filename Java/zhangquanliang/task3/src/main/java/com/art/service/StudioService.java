package com.art.service;

import com.art.pojo.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 工作室管理
 * @author suger
 * @date 2018/11/4
 */
public interface StudioService {

    //  新增工作室简介
    Boolean insert(Studio record);
    //  删除工作室简介
    Boolean delete(Integer id);
    //  查询单个工作室简介
    Studio getStudio(Integer id);
    //  查询工作室简介列表
    List<Studio> getStudio(@Param("status") Boolean status, @Param("updateBy") String updateBy);
    //  更新工作室简介
    Boolean update(Studio record);

}
