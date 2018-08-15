package com.opt.service.impl;


import com.opt.dao.mapper.ProfessionMapper;
import com.opt.model.Page;
import com.opt.model.Profession;
import com.opt.service.ProfessionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProfessionServiceImpl implements ProfessionService {

    private static Logger logger = Logger.getLogger(ProfessionServiceImpl.class);

    @Autowired
    private ProfessionMapper professionMapper;

    @Override
    public int findAllCount() {
        return professionMapper.findAllCount();
    }

    @Override
    public Page<Profession> findByPage(int nowpage, int pagesize) {
        HashMap<String,Object> hashMap = new HashMap();
        Page<Profession> page = new Page<>();

//        每页记录数
        int pageSize = pagesize;

//        封装当前页
        page.setCurrPage(nowpage);

//        封装每页记录数
        page.setPageSize(pageSize);

//        获取总记录数封装
        int totalC = professionMapper.findAllCount();
        page.setTotalConut(totalC);

//        向上取整 获取总页数
        double totalP = totalC;
        Double dbc = Math.ceil(totalP/pageSize);
        page.setTotalPage(dbc.intValue());

//        设置页面limit start size
        logger.info(hashMap.put("start",(nowpage-1)*pageSize));
        logger.info(hashMap.put("size",page.getPageSize()));
        page.setPages( professionMapper.findByPage(hashMap));

        return page;
    }

    @Override
    public List<Profession> findAll() {
        return professionMapper.findAll();
    }
}
