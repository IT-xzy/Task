package com.jnshutask.security;

import com.jnshutask.pojo.TaUser;
import com.jnshutask.service.TaMenuService;
import com.jnshutask.service.TaUserService;
import com.jnshutask.util.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class TaUserDetailsServiceImp implements UserDetailsService {
    @Autowired
    private TaUserService userService;

    @Autowired
    private TaMenuService menuService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        TaUser user = userService.selectUserByUsername(username);
        if (user.getUserId() != null) {
            String permissions = this.menuService.findUserPermissions(user.getUsername());
            //理解注释；
            System.out.println(user.getUsername() + "对应的权限为：" + permissions);
            boolean notLocked = false;
            String str = "1";
            //判断锁定状态
            if (StringUtils.equals(TaUser.STATUS_VALID, user.getStatus())) {
                notLocked = true;
            }
            TaUserDetails userDetails = new TaUserDetails(user.getUsername(), user.getPassword(), true, true, true, notLocked,
                    AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
            userDetails.setTheme(user.getTheme());
            userDetails.setAvatar(user.getAvatar());
            userDetails.setEmail(user.getEmail());
            userDetails.setMobile(user.getMobile());
            userDetails.setSsex(user.getSsex());
            userDetails.setUserId(user.getUserId());
            userDetails.setPassword(user.getPassword());
            //设置登录时间在前台显示
            userDetails.setLoginTime(DateUtil.getDateFormat(new Date(), DateUtil.FULL_DATE_FORMAT));
            //手机号登录需要修改状态
            //            if (isMobile)
            //                userDetails.setLoginType(LoginType.sms);
            return userDetails;
        } else {
            throw new UsernameNotFoundException("账号不存在");
        }
    }
}