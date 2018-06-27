package hzw.model;

import java.io.Serializable;

public class User implements Serializable {
    // 服务端与客户端序列化UID必须一致 数据回传时需通过该值反序列化
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String userName;
    private String password;
    private String salt;
    private Long create_at;
    private Long update_at;
    private String userIphone;
    private String userPhoto;
    private String userEmail;
    private String userCode;
    private Integer emailState;

    public User(){}

    public User(Long userId,String userPhoto){
        this.userId = userId;
        this.userPhoto = userPhoto;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
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

    public String getUserIphone() {
        return userIphone;
    }

    public void setUserIphone(String userIphone) {
        this.userIphone = userIphone;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Integer getEmailState() {
        return emailState;
    }

    public void setEmailState(Integer emailState) {
        this.emailState = emailState;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", userIphone=" + userIphone +
                ", userPhoto='" + userPhoto + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
