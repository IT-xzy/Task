package com.jnshu.mapper;

import com.jnshu.entity.Art;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface ArtMapper {

    //新增作品
    boolean insertArt(Art art);

    //根据查询条件获取作品列表
    List<Art> findArtSelective(Art art);

    //获取作品详情
    Art findArtDetail(long id);

    //根据主键删除作品
    boolean deleteArt(long id);

    //查询记录数
    long findArtTotal();

    //根据主键选择性更新非空字段
    boolean updateArtSelective(Art art);

    //作品上下架
   /* boolean isOnlineArt(@RequestParam("boolean")boolean status,@RequestParam("id")long id);*/
    boolean isOnlineArt(Art art);
}
