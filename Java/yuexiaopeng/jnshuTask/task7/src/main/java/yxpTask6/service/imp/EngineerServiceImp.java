package yxpTask6.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yxpTask6.dao.EngineerDao;
import yxpTask6.pojo.Engineer;
import yxpTask6.service.EngineerService;


@Service
public class EngineerServiceImp implements EngineerService
{
    @Autowired
    private EngineerDao engineerDao;
    //查询所有的工程师简介
    public Engineer listEngineer(int engineerId)
    {
            return engineerDao.selectEngineer(engineerId);
    }
}
