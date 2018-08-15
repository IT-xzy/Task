package task.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import task.dao.AmountDao;
import task.pojo.Amount;
import task.service.AmountService;

@Service
public class AmountServiceImp implements AmountService
{
    @Autowired
    private AmountDao amountDao;
    //根据更新时间选出在线人数和毕业人数
    public Amount selectAmount(Long updateAt)
    {
        return amountDao.selectAmount(updateAt);
    }
}
