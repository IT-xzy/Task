package com.art.service;

import com.art.pojo.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 轮播图的service
 * @author suger
 * @date 2018-11-01
 */
public interface BannerService {

    // 新增 banner
    Boolean insert(Banner record);
     // 更新 banner
    Boolean update(Banner record);
     // 根据ID删除 banner
    Boolean delete(Integer id);
    // 根据ID查询
    Banner getBanner(Integer id);
    // 条件查询
    List<Banner> findBanners(Boolean status,  String updateBy);

}
