package jnshu.pojo;

public class RegisterAccount {
    String account;
    String password;
    String password2;
    String trueName;
    String nickName;
    String sex;
    String phone;
    String email;

    int phoneToken;
    String salt;
    int id;

    public RegisterAccount() {
    }

    public RegisterAccount(String account, String password, String password2, String trueName, String nickName, String sex, String phone, String email, int phoneToken, String salt, int id) {
        this.account = account;
        this.password = password;
        this.password2 = password2;
        this.trueName = trueName;
        this.nickName = nickName;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.phoneToken = phoneToken;
        this.salt = salt;
        this.id = id;
    }

    @Override
    public String toString() {
        return "RegisterAccount{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", password2='" + password2 + '\'' +
                ", trueName='" + trueName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", phoneToken=" + phoneToken +
                ", salt='" + salt + '\'' +
                ", id=" + id +
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
