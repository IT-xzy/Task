package pojo;

import java.io.Serializable;

public class Permission implements Serializable {
    //ID 自增 主键
    private Long id;
    //操作对应url
    private String permission;
    //操作名称
    private String name;
    //1可以添加给用户、0禁止添加给用户
    private Long status;
    //0 禁止添加给用户
    private static final Long _0=0L;
    //1 可以添加给用户
    private static final Long _1=1L;
    //无参构造方法
    public Permission() {
    }
    //有参构造方法
    public Permission(Long id, String permission, String name, Long status) {
        this.id = id;
        this.permission = permission;
        this.name = name;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission role = (Permission) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", permission='" + permission + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                '}';
    }
}
