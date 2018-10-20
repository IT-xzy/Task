package com.admincrud.controller;

import com.admincrud.pojo.Admin;
import com.admincrud.service.AdminService;
import com.admincrud.service.ApplicationException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {
    /**
     * 查询
     */
    @Resource(name = "adminServiceImpl")
    private AdminService adminService;
    Logger logger = Logger.getLogger(AdminController.class);
    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public String queryAdmin(HttpServletRequest request) {
        logger.info("queryAdmins()");
        List<Admin> admins;
        try {
            admins = adminService.queryAllService();
            request.setAttribute("admins", admins);
        } catch (Exception e) {
            logger.info("数据库没有数据");
            if (e instanceof ApplicationException) {
                request.setAttribute("e", e);
                return "no";
            }
            return "error";
        }
        return "admin";
    }

    @RequestMapping(value = "/admins/id", method = RequestMethod.GET)
    public String queryAdmin(Integer id, HttpServletRequest request) {
        logger.info("queryAdmin()............................................");
        List<Admin> admins = new ArrayList<>();
        try {
            Admin admin = adminService.queryAdminService(id);
            admins.add(admin);
            request.setAttribute("admins", admins);
            logger.info("绑定完毕");
        } catch (Exception e) {
            if (e instanceof ApplicationException) {
                request.setAttribute("e", e);
                return "no";
            }
            return "error";
        }
        return "admin";
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/admins/{id}", method = RequestMethod.DELETE)
    public String deleteAdmin(@PathVariable("id") Integer id) {
        logger.info("deleteAdmin()");
        adminService.delAdminService(id);
        return "redirect:/admins";
    }

    @RequestMapping(value = "/admins", method = RequestMethod.DELETE)
    public String delAllAdmins() {
        logger.info("delAllAdmins()");
        adminService.delAdminsService();
        return "redirect:/admins";
    }

    /**
     * 新建
     *
     * @param admin
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String savaAdmin(Admin admin, HttpServletRequest request) {
        try {

            if (admin.getEnrolldate() == null || admin.getAdminCode() == null || admin.getPassword() == null) {
                throw new ApplicationException("账号,密码,注册时间不能为空!");
            }
            logger.info(admin);
            logger.info("savaAdmin()");
            adminService.saveAdminService(admin);
        } catch (Exception e) {
            logger.info(e);
            if (e instanceof ApplicationException) {
                logger.info(e);
                request.setAttribute("e", e);
                return "no";
            }
        }
        return "redirect:/admins";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.PUT)
    public String updateAdmin(Admin admin) {
        logger.info(admin);
        logger.info("updateAdmin()");
        adminService.updateAdminService(admin);
        return "redirect:/admins";
    }

}
