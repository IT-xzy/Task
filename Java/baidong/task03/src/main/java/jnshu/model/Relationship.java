package jnshu.model;

public class Relationship {
    @Override
    public String toString() {
        return "Relationship{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", moduleId=" + moduleId +
                '}';
    }

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
}