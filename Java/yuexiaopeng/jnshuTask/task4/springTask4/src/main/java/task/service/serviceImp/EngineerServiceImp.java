package task.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import task.dao.EngineerDao;
import task.pojo.Engineer;
import task.service.EngineerService;

@Service
public class EngineerServiceImp implements EngineerService
{
    @Autowired
    private EngineerDao engineerDao;
    //查询所有的工程师简介
    public Engineer selectEngineer()
    {
            return engineerDao.selectEngineer();
    }
}
