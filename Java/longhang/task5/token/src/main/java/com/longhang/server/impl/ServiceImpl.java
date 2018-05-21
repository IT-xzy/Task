package com.longhang.server.impl;

import com.longhang.dao.OkDao;
import com.longhang.model.User;
import com.longhang.server.UserService;
import com.longhang.util.Md5Utils;
import com.longhang.util.Token;

import javax.annotation.Resource;
import java.util.ArrayList;
@org.springframework.stereotype.Service
public class ServiceImpl implements UserService {
    @Resource
    private OkDao okDao;
    Token t=new Token();
    Md5Utils md=new Md5Utils();
    @Override
    public String getSelectByName(String name) {
        return okDao.selectByName(name);
    }

    @Override
    public Long getLoginTimeByName(String name) {
        return okDao.loginTimeByName(name);
    }

    @Override
    public ArrayList<String> getGetAllName() {
        return okDao.getAllName();
    }

    @Override
    public User getSelects(String name) {
        return okDao.selects(name);
    }
    @Override
    public void getInsert(String name,String password,String phone,Long create_at,Long logintime) {
        String name1=t.makeToken(name);
        String password1=md.MD5(t.makeToken(password));
        String phone1=t.makeToken(phone);
        this.okDao.insert(name1,password1,phone1,create_at,logintime);
    }

    @Override
    public void getUpdataByName(String name,Long logintime) {
        if (name!=null){
            String name1=t.makeToken(name);
        this.okDao.updateByName(name1,logintime);}
        }

    @Override
    public void getUpdataByName1(String name, Long logintime) {
        if (name!=null)
            this.okDao.updateByName(name,logintime);
    }

    @Override
    public void getUpdate(String name, String password, String phone,Long id) {
        if(name!=null && password!=null && phone!=null)
        {   String n=t.makeToken(name);
            String p=t.makeToken(password);
            String ph=t.makeToken(phone);
            this.okDao.update(n,p,ph,id);}
    }
}
