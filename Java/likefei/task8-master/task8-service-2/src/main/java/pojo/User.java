package pojo;

import java.io.Serializable;


public class User implements Serializable{
    //ID 自增 主键
    private Long id;
    //用户名
    private String name;
    //密码 不参与序列化
    private transient String password;
    //盐值  不参与序列化
    private transient String salt;
    //邮箱/登陆账号
    private String email;
    //手机/登陆账号
    private String phonenumber;
    //创建时间
    private Long createTime;
    //最后登陆时间
    private Long lastLoginTime;
    //头像
    private String image;
    //1有效 0禁止登陆
    private Long status;
    //0 禁止登陆
    private static final Long _0=0L;
    //1 有效
    private static final Long _1=1L;

    //无参构造方法
    public User() {
    }
    //有参构造方法

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //有参构造方法


    public User(Long id, String name, String password, String salt, String email, String phonenumber, Long createTime, Long lastLoginTime, String image, Long status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.salt = salt;
        this.email = email;
        this.phonenumber = phonenumber;
        this.createTime = createTime;
        this.lastLoginTime = lastLoginTime;
        this.image = image;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", email='" + email + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", image='" + image + '\'' +
                ", status=" + status +
                '}';
    }
}
