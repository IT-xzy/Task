package com.jnshuboot.testTask;

import com.jnshuboot.DemobootApplication;
import com.jnshuboot.dao.PermissionDao;
import com.jnshuboot.dao.SysRoleUserMapper;
import com.jnshuboot.dao.UserDao;
import com.jnshuboot.pojo.SysPermissionRole;
import com.jnshuboot.pojo.SysRole;
import com.jnshuboot.pojo.SysRoleUser;
import com.jnshuboot.pojo.SysUser;
import com.jnshuboot.pojo.example.SysRoleUserExample;
import com.jnshuboot.service.BSRoleService;
import com.jnshuboot.service.BSUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemobootApplication.class)
public class TestSecurity {
    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void testS1() {
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        SysUser sysUser = userDao.findByUserName("admin");
        System.out.println(sysUser);
    }

    @Test
    public void testS2() {
        PermissionDao permissionDao = (PermissionDao) applicationContext.getBean("permissionDao");
        List list = permissionDao.findAll();
        System.out.println("全部权限为" + list);
        List list1 = permissionDao.findByAdminUserId(2);
        System.out.println("单个权限为" + list1);
    }

    @Test
    public void test3() {
        SysUser sysUser = new SysUser();
        System.out.println(sysUser.toString());
    }

    @Autowired
    BSRoleService bsRoleService;

    @Test
    public void testRoleInsert() {
        SysRole sysRole = new SysRole();
        sysRole.setName("ROLE_USER4");
        sysRole.setDescription("test角色user3");
        SysPermissionRole sysPermissionRole = new SysPermissionRole();
        sysPermissionRole.setPermissionId(2);
        sysPermissionRole.setDescription("test角色user3");
        int i = bsRoleService.insertRole(sysRole, sysPermissionRole);
        log.info("增加角色的结果为 :" + i);
    }

    @Test
    public void testRoleDelete() {
        int i = 6;
        int j = bsRoleService.deleteRole(i);
        log.warn("删除的结果为 :" + j);
    }

    @Test
    public void testRoleUpdate() {
        SysPermissionRole sysPermissionRole = new SysPermissionRole();
        sysPermissionRole.setPermissionId(2);
        int i = bsRoleService.updateRole(10, sysPermissionRole);
        log.info("更新权限的结果为 :" + i);
    }

    @Test
    public void testRoleSelect() {
        List list = bsRoleService.selectRole();
        log.info("查询的所有角色及权限为 :" + list);
    }

    @Autowired
    BSUserService bsUserService;

    @Test
    public void testUserSelect() {
        List list = bsUserService.selectUsers();
        log.info("查询的所有数据为" + list);
    }

    @Test
    public void testUserInsert() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("test11");
        sysUser.setPassword("{noop}123456");
        sysUser.setDescription("我是一个测试用户");
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setSysRoleId(2);
        int i = bsUserService.insertUser(sysUser, sysRoleUser);
        log.info("插入数据的结果为 :" + i);
    }

    @Test
    public void testUserDelete() {
        int i = bsUserService.deleteUser(5);
        log.info("删除的数据的结果为" + i);
    }

    @Test
    public void testUserUpdate() {
        SysRoleUser sysRoleUser = new SysRoleUser();
        sysRoleUser.setSysRoleId(3);
        int i = bsUserService.updateUser(6, sysRoleUser);
        log.info("更新的数据为 :" + i);
    }

}
