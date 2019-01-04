package com.tiles.pojo;

/**
 * @author suger
 * @date 2018/11/19 15:27
 * 用户实体类
 */
public class User {

    private Long id;
    private String name;
    // 密码
    private String pwd;
    private String qq;
    private String email;
    private String tell;
    private String img;
    private String sex;
    private Integer age;
    private String school;
    // 立愿
    private String wish;
    // 签名或者宣言
    private String sign;
    private long createAt;
    private long updateAt;


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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTell() {
        return tell;
    }

    public void setTell(String tell) {
        this.tell = tell;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("User{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", pwd='").append(pwd).append('\'');
        sb.append(", qq='").append(qq).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", tell='").append(tell).append('\'');
        sb.append(", img='").append(img).append('\'');
        sb.append(", sex='").append(sex).append('\'');
        sb.append(", age=").append(age);
        sb.append(", school='").append(school).append('\'');
        sb.append(", wish='").append(wish).append('\'');
        sb.append(", sign='").append(sign).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append('}');
        return sb.toString();
    }
}
