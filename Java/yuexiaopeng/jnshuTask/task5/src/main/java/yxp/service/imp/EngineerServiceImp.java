package yxp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yxp.dao.EngineerDao;
import yxp.pojo.Engineer;
import yxp.service.EngineerService;


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
