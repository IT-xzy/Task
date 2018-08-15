package yxp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yxp.dao.ExcellentDao;
import yxp.pojo.Excellent;
import yxp.service.ExcellentService;

import java.util.List;

@Service
public class ExcellentServiceImp implements ExcellentService
{
    @Autowired
    private ExcellentDao excellentDao;
    //查询所有的优秀毕业生
    public List<Excellent> listExcellent()
    {
        return excellentDao.selectExcellent();
    }
}
