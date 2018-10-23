package com.jnshuboot.service.imp;

import com.jnshuboot.dao.SysRoleUserMapper;
import com.jnshuboot.dao.SysUserMapper;
import com.jnshuboot.pojo.SysRoleUser;
import com.jnshuboot.pojo.SysUser;
import com.jnshuboot.pojo.example.SysRoleExample;
import com.jnshuboot.pojo.example.SysRoleUserExample;
import com.jnshuboot.pojo.example.SysUserExample;
import com.jnshuboot.service.BSUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BSUserServiceImp implements BSUserService {

    @Autowired(required = false)
    SysUserMapper sysUserMapper;
    @Autowired(required = false)
    SysRoleUserMapper sysRoleUserMapper;

    @Override
    public List<SysRoleUser> selectUsers() {
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria();
        List<SysRoleUser> list = sysRoleUserMapper.selectByExample(sysRoleUserExample);
        log.info("查询所有用户-角色表数据为 :" + list);
        return list;
    }

    @Override
    public SysRoleUser selectByUserId(Integer userId) {
        SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
        sysRoleUserExample.createCriteria().andSysUserIdEqualTo(userId);
        List<SysRoleUser> list = sysRoleUserMapper.selectByExample(sysRoleUserExample);
        SysRoleUser sysRoleUser = list.get(0);
        return sysRoleUser;
    }

    @Override
    public int insertUser(SysUser sysUser, SysRoleUser sysRoleUser) {
        int i = -999;
        if (sysUser.getPassword() != null && sysUser.getUsername() != null && sysRoleUser.getSysRoleId() != null) {
            SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
            SysRoleExample sysRoleExample = new SysRoleExample();
            sysUserMapper.insertSelective(sysUser);
            Integer userId = sysUser.getId();
            log.info("增加的用户id为 :" + userId);
            sysRoleUser.setSysUserId(userId);
            i = sysRoleUserMapper.insertSelective(sysRoleUser);
            log.info("增加用户-角色表的数据成功 :" + i);
        }
        return i;
    }

    @Override
    public int deleteUser(Integer userId) {
        int i = -999;
        if (userId > 0) {
            SysUserExample sysUserExample = new SysUserExample();
            sysUserExample.createCriteria().andIdEqualTo(userId);
            sysUserMapper.deleteByExample(sysUserExample);
            log.info("删除的用户数据id为 :" + userId);
            SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
            sysRoleUserExample.createCriteria().andSysUserIdEqualTo(userId);
            i = sysRoleUserMapper.deleteByExample(sysRoleUserExample);
            log.info("删除的用户-角色表数据的userId为 :" + userId);
        }
        return i;
    }

    @Override
    public int updateUser(Integer userId, SysRoleUser sysRoleUser) {
        int i = -999;
        if (userId > 0 && sysRoleUser.getSysRoleId() > 0) {
            SysRoleUserExample sysRoleUserExample = new SysRoleUserExample();
            sysRoleUserExample.createCriteria().andSysUserIdEqualTo(userId);
            i = sysRoleUserMapper.updateByExampleSelective(sysRoleUser, sysRoleUserExample);
            log.info("更新用户-角色表数据的userid为 :" + userId);
            return i;
        }
        return i;
    }
}
