package com.affair;

import com.dao.TransferAccountsDao;
import com.pojo.StaffSalary;

public class TransferAccounts {
    private TransferAccountsDao transferAccountsDao;

    public void setTransferAccountsDao(TransferAccountsDao transferAccountsDao) {
        this.transferAccountsDao = transferAccountsDao;
    }

    public void transferAccounts(String out_name, String in_name, Integer money) throws Exception {
        Long time = System.currentTimeMillis();
//        找到出账账户
        StaffSalary out_staff = transferAccountsDao.findUserByName(out_name);
//        设置更新时间
        out_staff.setUpdate_at(time);
//        设置出账账户转出后的salary
        out_staff.setSalary((out_staff.getSalary() - money));
//        找到入账账户
        StaffSalary in_staff = transferAccountsDao.findUserByName(in_name);
        in_staff.setUpdate_at(time);
//        设置入账账户转入后的salary
        in_staff.setSalary(in_staff.getSalary() + money);
//        转出
        transferAccountsDao.lessMoney(out_staff);
//        System.out.println(5 / 0);
//        转入
        transferAccountsDao.moreMoney(in_staff);
        System.out.println("转账成功！");
//        输出转账后的结果
        System.out.println(transferAccountsDao.findUserByName(out_name));
        System.out.println(transferAccountsDao.findUserByName(in_name));
    }
}
