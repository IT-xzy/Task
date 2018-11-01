package jnshu.dao;

import jnshu.pojo.Account;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;

import java.util.List;

public interface AccountMapper {
    //    Account
    int insertAccount(Account record);

    int insertSelectiveAccount(Account record);

    List<Account> listAccount()throws Exception;

    //注册
    int register(RegisterAccount registerAccount)throws Exception;

    //验证模块
    RegisterAccount checkLogin(LoginAccount loginAccount)throws Exception;
}
