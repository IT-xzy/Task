package com.longhang.test.dao.impl;


import com.longhang.test.dao.UseDao;
import org.apache.log4j.Logger;

public class UseDaoImpl implements UseDao
{
    private Logger logger=Logger.getLogger(UseDaoImpl.class);
    public void mathod()
    {
        logger.info("from UseDaoImpl.mathod()");
        System.out.println("......from UseDaoImpl.mathod()");
    }
}
