package com.model;

public class Login {
    private int id;
    private String username;
    private String userpass;
    private Long create_at;
    private Long update_at;
    private Long landtime;

    public Long getLandtime() {
        return landtime;
    }

    public void setLandtime(Long landtime) {
        this.landtime = landtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userpass='" + userpass + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", landtime=" + landtime +
                '}';
    }
}
