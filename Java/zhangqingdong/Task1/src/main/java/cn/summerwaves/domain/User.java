package cn.summerwaves.domain;

/**
 * Created by summerwaves on 2017/7/18.
 */
public class User {
    private String userName;
    private String password;
    private int sex;

    public User(String userName, String password, int sex) {
        this.userName = userName;
        this.password = password;
        this.sex = sex;
    }

    public User() {

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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                '}';
    }
}