package com.admincrud.service;

import com.admincrud.dao.AdminDao;
import com.admincrud.pojo.Admin;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    Logger logger =Logger.getLogger(AdminService.class);
    @Resource(name = "adminDao")
    private AdminDao adminDao;
    @Override
    public List<Admin> queryAllService(){
        //String str =null;
        //str.length();
        logger.info("queryAllService()");
        List<Admin> admins;
        admins=adminDao.findAdmins();
        if (admins.size()==0){
            logger.info("数据库没有数据");
            throw new ApplicationException("没有数据");
        }
        return admins;
    }

    @Override
    public Admin queryAdminService(Integer id) {
        logger.info("queryAdminService()");
        Admin admin=null;
        admin=adminDao.findAdmin(id);
        if (admin==null){
            logger.info("queryAdminService():没有该行数据");
            throw new ApplicationException("没有该行数据，请重新输入正确的id");
        }
        return admin;
    }

    @Override
    public void saveAdminService(Admin admin) {
        logger.info("saveAdminService()");
        adminDao.saveAdmin(admin);
        logger.info("saveAdminService():执行完了");
    }

    @Override
    public void delAdminsService() {
        logger.info("delAdminsService()");
        adminDao.delAdmins();
        logger.info("执行完了");
    }

    @Override
    public void delAdminService(Integer id) {
        logger.info("delAdminService()");
        adminDao.delAdmin(id);
        logger.info("执行完了");
    }

    @Override
    public void updateAdminService(Admin admin) {
        logger.info("updateAdminService();");
        adminDao.updateAdmin(admin);
        logger.info("执行完了");
    }
}
