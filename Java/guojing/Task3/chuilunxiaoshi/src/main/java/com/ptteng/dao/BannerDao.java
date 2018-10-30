package com.ptteng.dao;

import com.ptteng.entity.Banner;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BannerDao {

    List<Banner> findBanner();

    Boolean deleteById(long id);

    Boolean updateBanner(Banner banner);

    long insertBanner(Banner banner);

}
