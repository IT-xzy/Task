package jnshu.pojo;

public class RegisterAccount {
    String account;
    String password;
    String trueName;
    String nickName;
    String sex;
    String phone;

    int phoneToken;
    String salt;
    int id;

    public RegisterAccount(String account, String password, String trueName, String nickName, String sex, String phone) {
        this.account = account;
        this.password = password;
        this.trueName = trueName;
        this.nickName = nickName;
        this.sex = sex;
        this.phone = phone;
    }

    public RegisterAccount() {

    }

    @Override
    public String toString() {
        return "RegisterAccount{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", trueName='" + trueName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone=" + phone +
                ", phoneToken=" + phoneToken +
                ", salt='" + salt + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoneToken() {
        return phoneToken;
    }

    public void setPhoneToken(int phoneToken) {
        this.phoneToken = phoneToken;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
