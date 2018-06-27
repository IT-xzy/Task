package com.dao;

import com.pojo.StaffSalary;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface TransferAccountsDao {
    @Select("select * from staff where name=#{name}")
    StaffSalary findUserByName(String name) throws Exception;

    @Update("update staff set  salary=#{salary},update_at=#{update_at} where id=#{id}")
    void lessMoney(StaffSalary staffSalary) throws Exception;

    @Update("update staff set  salary=#{salary},update_at=#{update_at} where id=#{id}")
    void moreMoney(StaffSalary staffSalary) throws Exception;

}
