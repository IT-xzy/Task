package com.longhang.stuService.impl;

import com.longhang.model.User;
import com.longhang.stuDao.OkDao;
import com.longhang.stuService.UserService;
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
    public void getInsert(String name,String password,Long create_at,Long logintime) {
        String name1=t.makeToken(name);
        String password1=md.MD5(t.makeToken(password));
        this.okDao.insert(name1,password1,create_at,logintime);
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
    public void getUpdate(String name, String password,Long id) {
        if(name!=null && password!=null)
        {   String n=t.makeToken(name);
            String p=t.makeToken(password);
            this.okDao.update(n,p,id);}
    }
}
