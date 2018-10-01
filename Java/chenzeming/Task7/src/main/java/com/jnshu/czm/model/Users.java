package com.jnshu.czm.model;

public class Users {

//    private Integer id;

    private String  username;

    private String telephone;

    private String email;

    private String photo;

    private String  password;

    private Long create_at;

    private String salt;



//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                ", password='" + password + '\'' +
                ", create_at=" + create_at +
                ", salt='" + salt + '\'' +
                '}';
    }
}
