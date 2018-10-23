package yxpTask6.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yxpTask6.dao.AmountDao;
import yxpTask6.pojo.Amount;
import yxpTask6.service.AmountService;


@Service
public class AmountServiceImp implements AmountService
{
    @Autowired
    private AmountDao amountDao;
    //根据更新时间选出在线人数和毕业人数
    public Amount listAmount(Long updateAt)
    {
        return amountDao.selectAmount(updateAt);
    }
}
