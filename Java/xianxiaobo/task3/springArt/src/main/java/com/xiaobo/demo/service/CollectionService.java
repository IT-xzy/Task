package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Collection;
import com.xiaobo.demo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CollectionService {
    public List<Collection> getList(Collection collection, Map<String,Object> pageData);
    public Boolean add(Collection collection);
    public Boolean update(Collection collection);
    public Boolean delete(Collection collection);
}
