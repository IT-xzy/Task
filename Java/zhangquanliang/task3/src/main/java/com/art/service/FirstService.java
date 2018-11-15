package com.art.service;

import com.art.pojo.First;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 一级作品集
 * @author suger
 * @date 2018/11/4
 */
public interface FirstService {

    // 新增作品集
    Boolean insert(First record);
    // 删除作品集
    Boolean delete(Integer id);
    // 查询单个作品集
    First getFirst(Integer id);
    //  根据 上架状态和最后编辑人 查询作品集
    List<First> getFirst(@Param("status") Boolean status, @Param("updateBy") String updateBy);
    //  更新作品集
    Boolean update(First record);


}
