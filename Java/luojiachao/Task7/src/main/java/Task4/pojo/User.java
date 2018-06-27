package Task4.pojo;


import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -8692874899984925625L;

    public User(String name, String sex, String username, String password, String major, String classes, String QQ, String Introduce, String email, String status, String avatar, String psw, String salt, String phone
                ) {
        this.name=name;
        this.sex=sex;
        this.username=username;
        this.password=password;
        this.major=major;
        this.classes=classes;
        this.QQ=QQ;
        this.introduce=Introduce;
        this.email=email;
        this.status=status;
        this.avatar=avatar;
        this.psw=psw;
        this.salt=salt;
        this.phone=phone;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", major='" + major + '\'' +
                ", classes='" + classes + '\'' +
                ", QQ='" + QQ + '\'' +
                ", introduce='" + introduce + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", avatar='" + avatar + '\'' +
                ", psw='" + psw + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    private int id;
    private long create_at;
    private long update_at;
    private String name;
    private String sex;
    private String username;
    private String password;
    private String major;
    private String classes;
    private String QQ;
    private String introduce;
    private String email;
    private String status;
    private String avatar;
    private String psw;
    private String salt;
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
