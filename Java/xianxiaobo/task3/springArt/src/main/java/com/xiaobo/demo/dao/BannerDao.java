package com.xiaobo.demo.dao;

import com.xiaobo.demo.pojo.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public interface BannerDao {
    public List<Banner> getList(@Param("banner")Banner banner, @Param("pageData") Map<String,Object> pageData);
    public Boolean add(Banner banner);
    public Boolean delete(Banner banner);
    public Boolean update(Banner banner);
    public Integer updateBatch(@Param("banner")Banner banner, @Param("idList") ArrayList idList);
    public Integer updateBatchSort(@Param("bannerList") ArrayList bannerList);
}
