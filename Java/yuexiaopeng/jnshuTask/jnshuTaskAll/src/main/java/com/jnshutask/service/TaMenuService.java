package com.jnshutask.service;

import com.jnshutask.pojo.TaMenu;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaMenuService {

    /**查询菜单信息
     * @param userName
     * @return
     */
    List<TaMenu> findUserMenus(String userName);


    /**查询用户权限
     * @param userName
     * @return
     */
    String findUserPermissions(String userName);

}
