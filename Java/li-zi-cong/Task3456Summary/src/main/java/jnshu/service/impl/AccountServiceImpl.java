package jnshu.service.impl;

import jnshu.dao.AccountMapper;
import jnshu.interceptor.TokenInterceptor;
import jnshu.pojo.Account;
import jnshu.pojo.LoginAccount;
import jnshu.pojo.RegisterAccount;
import jnshu.service.AccountService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("AccountDAOBean")
    private AccountMapper accountMapper;

    Logger logger = Logger.getLogger(AccountServiceImpl.class);

    @Override
    public int insertAccount(Account record) {
        return 0;
    }

    @Override
    public int insertSelectiveAccount(Account record) {
        return 0;
    }

    @Override
    public List<Account> listAccount() throws Exception {
        try {
            return accountMapper.listAccount();
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    @Override
    public int register(RegisterAccount registerAccount) throws Exception {
        try {
            return accountMapper.register(registerAccount);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return 0;
    }

    @Override
    public RegisterAccount checkLogin(LoginAccount loginAccount) throws Exception {


        try {
            return accountMapper.checkLogin(loginAccount);
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}
