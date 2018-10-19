package jnshu.pojo;

public class LoginAccount {
    String account;
    String password;

    public LoginAccount(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public LoginAccount() {

    }

    @Override
    public String toString() {
        return "LoginAccount{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
