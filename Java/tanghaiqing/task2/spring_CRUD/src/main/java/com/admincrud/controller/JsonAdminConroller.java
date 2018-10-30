package com.admincrud.controller;

import com.admincrud.pojo.Admin;
import com.admincrud.service.AdminService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
@Controller
@RequestMapping("/json")
public class JsonAdminConroller {
    /**
     * 查询
     */
    @Resource(name = "adminServiceImpl")
    private AdminService adminService;
    Logger logger = Logger.getLogger(AdminController.class);
    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    @ResponseBody
    public List<Admin> queryAdmin() {
        logger.info("queryAdmins()");
        List<Admin> admins;
        admins = adminService.queryAllService();
        return admins;
    }

    @RequestMapping(value = "/admins/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Admin queryAdmin(@PathVariable("id") Integer id) {
        logger.info("queryAdmin()............................................");
        return adminService.queryAdminService(id);
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
        return "redirect:/json/admins";
    }
    @RequestMapping(value = "/admins", method = RequestMethod.DELETE)
    public String delAllAdmins() {
        logger.info("delAllAdmins()");
        adminService.delAdminsService();
        return "redirect:/json/admins";
    }
    //http://ip/.....?name=zhangsan&age

    /**
     * 新建
     *
     * @param admin
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public String savaAdmin(@RequestBody Admin admin) {
        logger.info(admin);
        logger.info("savaAdmin()");
        adminService.saveAdminService(admin);
        return "redirect:/json/admins";
    }
    @RequestMapping(value = "/admin", method = RequestMethod.PUT)
    public String updateAdmin(@RequestBody Admin admin) {
        logger.info(admin);
        logger.info("updateAdmin()");
        adminService.updateAdminService(admin);
        return "redirect:/json/admins";
    }
}
