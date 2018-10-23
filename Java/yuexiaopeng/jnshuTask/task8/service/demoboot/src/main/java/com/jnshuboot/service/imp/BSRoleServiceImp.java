package com.jnshuboot.service.imp;

import com.jnshuboot.dao.SysPermissionMapper;
import com.jnshuboot.dao.SysPermissionRoleMapper;
import com.jnshuboot.dao.SysRoleMapper;
import com.jnshuboot.pojo.SysPermissionRole;
import com.jnshuboot.pojo.SysRole;
import com.jnshuboot.pojo.example.SysPermissionRoleExample;
import com.jnshuboot.pojo.example.SysRoleExample;
import com.jnshuboot.service.BSRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BSRoleServiceImp implements BSRoleService {
    @Autowired(required = false)
    SysRoleMapper sysRoleMapper;
    @Autowired(required = false)
    SysPermissionRoleMapper sysPermissionRoleMapper;

    @Override
    public List<SysPermissionRole> selectRole() {
        SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
        sysPermissionRoleExample.createCriteria();
        List<SysPermissionRole> list = sysPermissionRoleMapper.selectByExample(sysPermissionRoleExample);
        log.info("查询所有数据的结果为 :" + list);
        return list;
    }

    @Override
    public SysPermissionRole selectByRoleId(Integer roleId) {
        SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
        sysPermissionRoleExample.createCriteria().andRoleIdEqualTo(roleId);
        List<SysPermissionRole> list = sysPermissionRoleMapper.selectByExample(sysPermissionRoleExample);
        SysPermissionRole sysPermissionRole = list.get(0);
        log.info("查询单个数据的结果为 :" + sysPermissionRole);
        return sysPermissionRole;
    }

    @Override
    public int insertRole(SysRole sysRole, SysPermissionRole sysPermissionRole) {
        int i = -999;
        if (sysRole.getName() != null && sysPermissionRole.getPermissionId() != null) {
            sysRoleMapper.insertSelective(sysRole);
            int roleId = sysRole.getId();
            log.info("增加的角色id为 :" + roleId);
            sysPermissionRole.setRoleId(roleId);
            i = sysPermissionRoleMapper.insertSelective(sysPermissionRole);
            log.info("增加的权限角色关联数据的Id为 :" + sysPermissionRole.getId());
            return i;
        }
        return i;
    }

    @Override
    public int deleteRole(Integer roleId) {
        int i = -999;
        if (roleId > 0) {
            SysRoleExample sysRoleExample = new SysRoleExample();
            SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
            sysRoleExample.createCriteria().andIdEqualTo(roleId);
            sysRoleMapper.deleteByExample(sysRoleExample);
            log.info("删除的角色表数据id为 :" + roleId);
            sysPermissionRoleExample.createCriteria().andRoleIdEqualTo(roleId);
            i = sysPermissionRoleMapper.deleteByExample(sysPermissionRoleExample);
            log.info("删除的角色权限表数据中的roleId为" + roleId);
            return i;
        }
        return i;
    }

    @Override
    public int updateRole(Integer roleId, SysPermissionRole sysPermissionRole) {
        int i = -999;
        if (roleId > 0 && sysPermissionRole.getPermissionId() > 0) {
            SysPermissionRoleExample sysPermissionRoleExample = new SysPermissionRoleExample();
            sysPermissionRoleExample.createCriteria().andRoleIdEqualTo(roleId);
            i = sysPermissionRoleMapper.updateByExampleSelective(sysPermissionRole, sysPermissionRoleExample);
            return i;
        }
        return i;
    }
}
