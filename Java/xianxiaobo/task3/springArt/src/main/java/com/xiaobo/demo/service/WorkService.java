package com.xiaobo.demo.service;

import com.xiaobo.demo.pojo.Work;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public interface WorkService {
    public List<Work> getList(Work work, Map<String,Object> pageData);
    public Boolean add(Work work);
    public Boolean update(Work work);
    public Boolean delete(Work work);
    public List<Work> getWorkSearchList(String searchText,ArrayList categoryIdList,Map<String,Object> pageData);
}
