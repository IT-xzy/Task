package yxp.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yxp.dao.AmountDao;
import yxp.pojo.Amount;
import yxp.service.AmountService;


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
