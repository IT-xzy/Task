package POJO;

import java.sql.Date;

public class User3 {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User3(String n, Object o, String 男, String 同济大学) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserme() {
        return username;
    }

    public void setUserme(String userme) {
        this.username = userme;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddres() {
        return address;
    }

    public void setAddres(String addres) {
        this.address = addres;
    }


    @Override
    public String toString() {
        return "User3{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
