package com.jnshu.clroom.mapper;

import com.jnshu.clroom.beans.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BannerMapper {
    Boolean addBanner(Banner banner);

    Boolean deleteBannerById(Integer bannerId);

    Boolean updateBannerById(Integer bannerId);

    Banner selectBannerById(Integer bannerId);

    List<Banner> selectAllBanner();
}