package com.jnshuboot.security;

import com.jnshuboot.dao.PermissionDao;
import com.jnshuboot.dao.UserDao;
import com.jnshuboot.pojo.Permission;
import com.jnshuboot.pojo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyibo on 17/1/18.
 */
@Slf4j
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口
    @Autowired(required = false)
    UserDao userDao;
    @Autowired(required = false)
    PermissionDao permissionDao;

    public UserDetails loadUserByUsername(String username) {
        SysUser user = userDao.findByUserName(username);
        log.warn(username + ": 用户的角色为 :" + user);
        if (user != null) {
            //根据用户id查出对应的权限列表
            List<Permission> permissions = permissionDao.findByAdminUserId(user.getId());
            log.info(username + "用户的权限为 :" + permissions);
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Permission permission : permissions) {
                if (permission != null && permission.getName() != null) {
                    //将权限队形添加到权限中
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    log.info(username + ": 用户的权限为 :" + permission.getName());
                    //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }
//    @Autowired
//    UserDao userDao;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户
//        SysUser user = userDao.findByUserName(username);
//        if(user == null){
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
//        for(SysRole role:user.getRoles())
//        {
//            authorities.add(new SimpleGrantedAuthority(role.getName()));
//            System.out.println(role.getName());
//        }
//        return new org.springframework.filterFile.core.userdetails.User(user.getUsername(),
//                user.getPassword(), authorities);
//    }
}
