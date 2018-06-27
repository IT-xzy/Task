package pojo;

import java.io.Serializable;

public class Role implements Serializable{
    //ID 自增 主键
    private Long id;
    //角色名称
    private String role;
    //角色类型/描述
    private String type;
    //1可以添加给用户、0禁止添加给用户
    private Long status;
    //0 禁止添加给用户
    private static final Long _0=0L;
    //1 可以添加给用户
    private static final Long _1=1L;
    //无参构造方法
    public Role() {
    }
    //有参构造方法
    public Role(Long id, String role, String type, Long status) {
        this.id = id;
        this.role = role;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }
}
