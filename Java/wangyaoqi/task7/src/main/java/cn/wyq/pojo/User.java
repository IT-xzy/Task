package cn.wyq.pojo;

public class User {
    public int userId;
    public String userName;
    public String password;
    public String salt;
    public String email;
    public String telephone;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "User{"+
                "id="+userId+
                ",userName='"+userName+'\''+
                ",password='"+password+'\''+
                ",salt='"+salt+'\''+
                ",email='"+email+'\''+
                ",telephone='"+telephone+'\''+
                "}";
    }
}
