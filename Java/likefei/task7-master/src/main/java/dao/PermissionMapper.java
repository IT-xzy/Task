package dao;

import pojo.Permission;

import java.util.Set;

public interface PermissionMapper {
    public Permission insertPermission(Permission permission);
    public void deletePermission(Long pid);
    public Set<Permission> findeByUser(String username);
}
