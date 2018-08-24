package wyq.webapp.pojo;

public class User {
    public int userId;
    public String userName;
    public String password;
    public String salt;

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

    @Override
    public String toString() {
        return "User{"+
                "id="+userId+
                ",userName='"+userName+'\''+
                ",password='"+password+'\''+
                ",salt='"+salt+'\''+
                "}";
    }
}
