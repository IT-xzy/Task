package task.dao;

import task.pojo.Amount;

public interface AmountDao
{
    Amount selectAmount(Long updateAt);
}
