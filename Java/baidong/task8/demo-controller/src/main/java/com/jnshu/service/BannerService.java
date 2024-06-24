package com.jnshu.service;

import com.jnshu.model.Banner;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BannerService {
    List<Banner> selectAll();
}
