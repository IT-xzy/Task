package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pojo.Permission;
import pojo.Role;
import pojo.User;
import service.UserRmiService;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    UserRmiService userRmiService;

    /**
     * 添加角色
     * @param username
     * @param info
     */
    private void addRole(String username, SimpleAuthorizationInfo info) {
        Set<Role> roles =userRmiService.findeRoleByUser(username);
        if(roles!=null&&roles.size()>0){
            for (Role role : roles) {
                info.addRole(role.getRole());
            }
        }
    }

    /**
     * 添加权限
     * @param username
     * @param info
     * @return
     */
    private SimpleAuthorizationInfo addPermission(String username,SimpleAuthorizationInfo info) {
        Set<Permission> permissions = userRmiService.findePerByUser(username);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermission());//添加权限
        }
        return info;
    }

    /**
     * 获取授权信息
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //用户名
        String username = (String) principals.fromRealm(getName()).iterator().next();
        //根据用户名来添加相应的权限和角色
        if(!StringUtils.isEmpty(username)){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            addPermission(username,info);
            addRole(username,info);
            return info;
        }
        return null;
    }

    /**
     * 登录验证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken ) throws AuthenticationException {
        //令牌——基于用户名和密码的令牌
        ShiroToken token = (ShiroToken) authcToken;
        //令牌中可以取出用户名
        String username = token.getUsername();
        String password = token.getMd5saltpd();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name", username);
        map.put("password", password);
        //让shiro框架去验证账号密码
        //这里应该重写验证方法改成我自己的MD5检验而不是用shiro的md5，由于不会写，所以就干脆传入了一个我自己根据盐值加密后的密码，等于调用了两次sql语句，相当麻烦
        //先实现功能，日后完善这里na
        //这里判断账号为空没有意义！判断账号或密码错误也没意义 因为之前处理过所以只能是密码错误！
        if(!StringUtils.isEmpty(username)){
            User user = userRmiService.login(map);
            if(null == user){
                throw new AccountException("账号或密码不正确");
            }
            if (user.getStatus()==0){
                throw new DisabledAccountException("帐号已经禁止登录！");
            }
            return new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
        }
        return null;
    }

    /**
     * 清空当前用户权限信息
     */
    public  void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 指定principalCollection 清除
     */
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}
