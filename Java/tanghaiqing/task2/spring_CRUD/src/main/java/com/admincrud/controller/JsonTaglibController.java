package com.admincrud.controller;

import com.admincrud.pojo.Admin;
import com.admincrud.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/jsonTaglib")
public class JsonTaglibController {
    /**
     * 查询
     */
    @Resource(name = "adminServiceImpl")
    private AdminService adminService;
    Logger logger = Logger.getLogger(AdminController.class);

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public String queryAdmin(HttpServletRequest request) {
        logger.info("queryAdmins()");
        List<Admin> admins = null;
        admins = adminService.queryAllService();
        request.setAttribute("admins", admins);
        return "jsonAdmins";
    }

    @RequestMapping(value = "/admins/{id}", method = RequestMethod.GET)
    public String queryAdmin(@PathVariable("id")Integer id, HttpServletRequest request) {
        logger.info("queryAdmin()............................................");
        List<Admin> admins = new ArrayList<>();
        Admin admin = adminService.queryAdminService(id);
        admins.add(admin);
        request.setAttribute("admins", admins);
        return "jsonAdmins";
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
        return "redirect:jsonTaglib/admins";
    }

    @RequestMapping(value = "/admins", method = RequestMethod.DELETE)
    public String delAllAdmins() {
        logger.info("delAllAdmins()");
        adminService.delAdminsService();
        return "redirect:jsonTaglib/admins";
    }

    /**
     * 新建
     *
     * @param admin
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String savaAdmin(@RequestBody Admin admin, HttpServletRequest request) {
        logger.info(admin);
        logger.info("savaAdmin()");
        adminService.saveAdminService(admin);
        return "redirect:jsonTaglib/admins";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.PUT)
    public String updateAdmin(Admin admin) {
        logger.info(admin);
        logger.info("updateAdmin()");
        adminService.updateAdminService(admin);
        return "redirect:jsonTaglib/admins";
    }


}
