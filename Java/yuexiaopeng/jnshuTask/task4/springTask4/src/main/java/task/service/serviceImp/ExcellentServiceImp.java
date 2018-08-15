package task.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.dao.ExcellentDao;
import task.pojo.Excellent;
import task.service.ExcellentService;

import java.util.List;

@Service
public class ExcellentServiceImp implements ExcellentService
{
    @Autowired
    private ExcellentDao excellentDao;
    //查询所有的优秀毕业生
    public List<Excellent> selectExcellent()
    {
        return excellentDao.selectExcellent();
    }
}
