package yxp.dao;

import yxp.pojo.Amount;

public interface AmountDao
{
    //根据更新时间查询
    Amount selectAmount(Long updateAt);
}
