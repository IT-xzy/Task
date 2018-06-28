package com.jnshu.service.Impl;
import com.jnshu.dao.ChecksDao;
import com.jnshu.service.ChecksService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ChecksServiceImpl implements ChecksService {
    @Resource
    private ChecksDao checksDao;


}
