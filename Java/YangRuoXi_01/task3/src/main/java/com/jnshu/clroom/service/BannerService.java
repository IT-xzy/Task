package com.jnshu.clroom.service;

import com.jnshu.clroom.beans.Banner;

import java.util.List;

public interface BannerService {

    Boolean addBanner(Banner banner);

    Boolean deleteBannerById(Integer bannerId);

    Boolean updateBannerById(Integer bannerId);

    Banner selectBannerById(Integer bannerId);

    List<Banner> selectAllBanner();
}
