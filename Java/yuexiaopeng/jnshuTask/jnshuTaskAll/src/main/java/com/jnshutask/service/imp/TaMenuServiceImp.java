package com.jnshutask.service.imp;

import com.jnshutask.dao.TaMenuDao;
import com.jnshutask.pojo.TaMenu;
import com.jnshutask.service.TaMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class TaMenuServiceImp implements TaMenuService {
    @Autowired
    TaMenuDao taMenuDao;
    @Override
    public List<TaMenu> findUserMenus(String userName) {
        return this.taMenuDao.findUserMenus(userName);
    }

    @Override
    public String findUserPermissions(String userName) {
        List<TaMenu> list = taMenuDao.findUserPermissions(userName);
//        list.forEach(System.out::println);
        return list.stream().map(TaMenu::getPerms).collect(Collectors.joining(","));
    }
}
