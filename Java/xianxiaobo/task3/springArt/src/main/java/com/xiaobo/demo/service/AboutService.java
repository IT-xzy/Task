package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.About;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AboutService {
    public List<About> getList(About about, Map<String,Object> pageData);
    public Boolean add(About about);
    public Boolean update(About about);
    public Boolean delete(About about);
}
