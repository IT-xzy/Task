package pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User  {
    private long id;
    @Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{6,13}$",message = "用户名必须是大写字母开头,长度为7-14位")
    private  String name;
    @Pattern(regexp = "[a-zA-Z0-9_]{5,7}",message ="密码长度为5-7位")
    private  String password;
    private  String salt;
    private long create_time;
    private long update_time;
    @NotNull(message = "手机号码不能为空")
    private String mobile_phone;
    private String mailbox;
    private String icon;

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(long update_time) {
        this.update_time = update_time;
    }
}
