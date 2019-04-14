package com.ptteng.model;

public class RoleModuleRelation {
    private Long id;

    private Long roleId;

    private Long moduleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    @Override
    public String toString() {
        return "RoleModuleRelation{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }
}