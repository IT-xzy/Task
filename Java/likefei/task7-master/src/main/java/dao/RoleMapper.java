package dao;

import pojo.Role;

import java.util.Set;

public interface RoleMapper {

    public Role insertRole(Role role);
    public void deleteRole(Long rid);

    public Set<Role> findeByUser(String username);

    public void correlationPermissions(Long rid, Long... pids);
    public void uncorrelationPermissions(Long rid, Long... pids);
}
