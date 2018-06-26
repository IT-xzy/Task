package com.ssm_yl.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm_yl.dao.Mapper;
import com.ssm_yl.pojo.Category;
import com.ssm_yl.service.PageInterface;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PageImpl implements PageInterface {
    @Autowired
    Mapper mapper;
    public PageInfo page(Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Category> category = mapper.list();
        PageInfo page = new PageInfo(category);
        return page;

    }
}
