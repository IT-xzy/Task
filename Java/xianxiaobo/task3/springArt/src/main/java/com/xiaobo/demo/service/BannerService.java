package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Banner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public interface BannerService {
    public List<Banner> getList(Banner banner, Map<String,Object> pageData);
    public Boolean add(Banner banner);
    public Boolean update(Banner banner);
    public Boolean delete(Banner banner);
    public Integer updateBatch(Banner banner, ArrayList idList);
    public Integer updateBatchSort(ArrayList bannerList);
}
