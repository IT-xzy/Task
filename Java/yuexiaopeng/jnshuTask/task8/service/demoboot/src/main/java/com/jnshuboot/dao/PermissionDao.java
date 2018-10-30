package com.jnshuboot.dao;


import com.jnshuboot.pojo.Permission;

import java.util.List;

/**
 * Created by yangyibo on 17/1/20.
 */
public interface PermissionDao {
    List<Permission> findAll();

    List<Permission> findByAdminUserId(int userId);
}
