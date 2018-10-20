package com.admincrud.dao;

import com.admincrud.pojo.Admin;

import java.util.List;
public interface AdminDao {
    List<Admin> findAdmins();
    Admin findAdmin(Integer id);
    void saveAdmin(Admin admin);
    void delAdmin (Integer id);
    void delAdmins();
    void updateAdmin(Admin admin);
}
