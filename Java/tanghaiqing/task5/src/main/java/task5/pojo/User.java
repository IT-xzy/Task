package task5.pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import task5.util.MD5Utils;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {

    private Integer userID;
    @NotNull(message = "名字不能为空")
    private String userName;
    @Range(min = 0, max = 200, message = "年龄范围在0-200之间 by range")
    private Integer age;
    //校验长度，可以用于Array,Collection,Map,String
    @Size(min = 4, max = 12, message = "用户名长度错误 by size")
    private String adminCode;
    //校验长度，只能用于String
    @Length(min = 4, max = 16, message = "密码长度错误 by length")
    private String password;
    @Pattern(regexp = "^\\d{11}$", message = "手机格式不正确,不是11位")
    private String telephone;
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$", message = "邮箱格式不正确")
    private String emailaccount;
    private Long creatTime;
    private Long updateTime;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmailaccount() {
        return emailaccount;
    }

    public void setEmailaccount(String emailaccount) {
        this.emailaccount = emailaccount;
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", adminCode='" + adminCode + '\'' +
                ", password='" + password + '\'' +
                ", telephone='" + telephone + '\'' +
                ", emailaccount='" + emailaccount + '\'' +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                '}';
    }
    public static User falseDate(){
        User user =new User();
        user.setUserID(1);
        user.setUserName("唐海清");
        user.setAge(22);
        user.setAdminCode("1015320765");
        user.setPassword(MD5Utils.getSaltMD5("1456987"));
        user.setTelephone("17688432366");
        user.setEmailaccount("1015320765@qq.com");
        user.setCreatTime(System.currentTimeMillis());
        return user;
    }
}
