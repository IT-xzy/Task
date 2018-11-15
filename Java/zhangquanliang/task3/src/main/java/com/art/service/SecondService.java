package com.art.service;

import com.art.pojo.Second;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 作品分类
 * @author suger
 * @date 2018/11/4
 */
public interface SecondService {

    // 新增作品分类
    Boolean insert(Second record);
    // 删除作品分类
    Boolean delete(Integer id);
    //  查询单个作品分类
    Second getSecond(Integer id);
    //  根据 上架状态和最后编辑人 查询作品分类列表
    List<Second> getSecond(@Param("status") Boolean status, @Param("updateBy") String updateBy);
     //  更新作品分类
    Boolean update(Second record);

}
