package yxpTask6.dao;

import yxpTask6.pojo.Amount;

public interface AmountDao
{
    //根据更新时间查询
    Amount selectAmount(Long updateAt);
}
