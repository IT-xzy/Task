package com.admincrud.service;

import com.admincrud.pojo.Admin;

import java.util.List;

public interface AdminService {
     List<Admin> queryAllService();
     Admin queryAdminService(Integer id);
     void saveAdminService(Admin admin);
     void delAdminsService();
     void delAdminService(Integer id);
     void updateAdminService(Admin admin);
}
