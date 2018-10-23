package com.jnshutask.service.imp;


import com.jnshutask.dao.TaUserDao;
import com.jnshutask.dao.TaUserRoleDao;
import com.jnshutask.pojo.TaUser;
import com.jnshutask.pojo.TaUserRole;
import com.jnshutask.pojo.example.TaRoleExample;
import com.jnshutask.pojo.example.TaUserExample;
import com.jnshutask.pojo.example.TaUserRoleExample;
import com.jnshutask.service.TaUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TaUserServiceImp implements TaUserService {

    @Autowired(required = false)
    TaUserDao taUserDao;
    @Autowired(required = false)
    TaUserRoleDao taUserRoleDao;

    @Override
    public List<TaUser> selectUsers() {
        TaUserExample taUserExample = new TaUserExample();
        List<TaUser> list = taUserDao.selectByExample(taUserExample);
        log.info("查询所有user表数据为 :" + list);
        return list;
    }

    @Override
    public List<TaUserRole> selectUserRoles() {
        TaUserRoleExample taUserRoleExample = new TaUserRoleExample();
        List<TaUserRole> list = taUserRoleDao.selectByExample(taUserRoleExample);
        log.info("查询所有user-role表数据为 :" + list);
        return list;
    }

    @Override
    public TaUserRole selectUserRoleByUserId(Long userId) {
        TaUserRoleExample  taUserRoleExample= new TaUserRoleExample();
        try{
            taUserRoleExample.createCriteria().andUserIdEqualTo(userId);
            List<TaUserRole> list = taUserRoleDao.selectByExample(taUserRoleExample);
            TaUserRole taUserRole = list.get(0);
            return taUserRole;
        }catch(Exception e){
            //userId为null或数据不存在
            log.error("查询的userId为:{}的userRole数据不存在,具体原因为:{}",userId,e.getMessage());
        }
        return new TaUserRole();
    }
    @Override
    public TaUser selectUserByUserId(Long userId) {
        TaUserExample  taUserExample= new TaUserExample();
        try{
            taUserExample.createCriteria().andUserIdEqualTo(userId);
            List<TaUser> list = taUserDao.selectByExample(taUserExample);
            TaUser taUser = list.get(0);
            return taUser;
        }catch(Exception e){
            //username为nul或数据或不存在
            log.error("查询的userId为:{}的user数据不存在,错误原因为:{}",userId,e.getMessage());
        }

        return new TaUser();
    }
    @Override
    public TaUser selectUserByUsername(String userName) {
        TaUserExample  taUserExample= new TaUserExample();
        try{
            taUserExample.createCriteria().andUsernameEqualTo(userName);
            List<TaUser> list = taUserDao.selectByExample(taUserExample);
            TaUser taUser = list.get(0);
            return taUser;
        }catch(Exception e){
            //username为nul或数据或不存在
            log.error("查询的username为:{}的user数据不存在,错误原因为:{}",userName,e.getMessage());
        }

        return new TaUser();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){return new BCryptPasswordEncoder();}

    @Override
    public int insertUser(TaUser taUser, TaUserRole taUserRole) {
        int i = -999;
        if (taUser.getPassword() != null && taUser.getUsername() != null && taUserRole.getRoleId() != null) {
            TaUserRoleExample taUserRoleExample = new TaUserRoleExample();
            TaRoleExample taRoleExample = new TaRoleExample();
            //将密码加密，使用security框架自带的加密
            String psswordEncrypt=this.bCryptPasswordEncoder().encode(taUser.getPassword());
            taUser.setPassword(psswordEncrypt);
            taUser.setCrateTime(System.currentTimeMillis());
            taUser.setModifyTime(System.currentTimeMillis());
            taUser.setLastLoginTime(System.currentTimeMillis());
            taUserDao.insertSelective(taUser);
            Long userId = taUser.getUserId();
            log.info("增加的用户id为 :" + userId);
            taUserRole.setUserId(userId);
            i = taUserRoleDao.insertSelective(taUserRole);
            log.info("增加用户-角色表的数据成功 :" + i);
        }
        log.error("增加user表的数据错误");
        return i;
    }

    @Override
    public int deleteUser(Long userId) {
        int i = -999;
        if (userId > 0) {
            //删除user表数据
            TaUserExample taUserExample = new TaUserExample();
            taUserExample.createCriteria().andUserIdEqualTo(userId);
            taUserDao.deleteByExample(taUserExample);
            log.info("删除的用户数据id为 :" + userId);
            //删除关联表数据
            TaUserRoleExample taUserRoleExample = new TaUserRoleExample();
            taUserRoleExample.createCriteria().andUserIdEqualTo(userId);
            i = taUserRoleDao.deleteByExample(taUserRoleExample);
            log.info("删除的用户-角色表数据的userId为 :" + userId);
        }
        log.error("删除userId为:{}的用户数据失败",userId);
        return i;
    }

    @Override
    public int updateUserRole(Long userId, TaUserRole taUserRole) {
        int i = -999;
        if (userId > 0 && taUserRole.getRoleId() > 0) {
            TaUserRoleExample taUserRoleExample = new TaUserRoleExample();
            taUserRoleExample.createCriteria().andUserIdEqualTo(userId);
            //对密码进行加密
            i = taUserRoleDao.updateByExampleSelective(taUserRole, taUserRoleExample);
            log.info("更新用户-角色表数据的userid为 :" + userId);
            return i;
        }
        log.error("更新userId为:{}的user-role数据失败",userId);
        return i;
    }
    @Override
    public int updateUser(Long userId, TaUser taUser) {
        int i = -999;
        if (userId > 0 && taUser.getUserId() > 0) {
            TaUserExample taUserExample = new TaUserExample();
            taUserExample.createCriteria().andUserIdEqualTo(userId);
            //对密码进行加密
            i = taUserDao.updateByExampleSelective(taUser, taUserExample);
            log.info("更新用户-角色表数据的userid为 :{}" , userId);
            return i;
        }
        log.error("更新userId为:{}的user数据失败",userId);
        return i;
    }
}
