package com.longhang.model;
public class User {

    public User(String name1, String password1, String phone1, Long create_at, Long logintime) {
        this.create_at=create_at;
        this.name=name1;
        this.logintime=logintime;
        this.phone=phone1;
        this.password=password1;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getLogintime() {
        return logintime;
    }

    public void setLogintime(Long logintime) {
        this.logintime = logintime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    private Long id;
    private String name;
    private Long logintime;
    private Long create_at;
    private String password;
    private String phone;


  public User(){}
  public User(String name, Long create_at,String password,String phone,Long logintime,Long id){
      this.id=id;
      this.create_at=create_at;
      this.name=name;
      this.logintime=logintime;
      this.phone=phone;
      this.password=password;
  }

}
