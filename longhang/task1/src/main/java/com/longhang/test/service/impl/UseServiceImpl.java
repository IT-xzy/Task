package com.longhang.test.service.impl;

import com.longhang.test.dao.UseDao;
import com.longhang.test.dao.impl.UseDaoImpl;
import com.longhang.test.service.UseService;
import org.apache.log4j.Logger;

public class UseServiceImpl implements UseService
{
    private Logger logger=Logger.getLogger(UseDaoImpl.class);
    private UseDaoImpl useDao;
    public void setUseDao(UseDaoImpl useDao){
        this.useDao=useDao;
    }
    @Override
    public void processMathod()
    {
        logger.info("from UseDaoImpl.processmathod()");
        System.out.println("......from UseDaoImpl.processmathod()");
       // useDao.mathod();
    }
}
