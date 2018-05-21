package lujing.pojo;

public class User {
    private Integer id;

    private String name;

    private String email;

    private Integer emailStatus;

    private String phoneNum;

    private String salt;

    private String desPassword;

    public User(Integer id, String name, String email, Integer emailStatus, String phoneNum, String salt, String desPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.emailStatus = emailStatus;
        this.phoneNum = phoneNum;
        this.salt = salt;
        this.desPassword = desPassword;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(Integer emailStatus) {
        this.emailStatus = emailStatus;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getDesPassword() {
        return desPassword;
    }

    public void setDesPassword(String desPassword) {
        this.desPassword = desPassword == null ? null : desPassword.trim();
    }
}