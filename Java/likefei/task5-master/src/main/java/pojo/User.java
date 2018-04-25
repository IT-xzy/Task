package pojo;

import org.aspectj.lang.annotation.Pointcut;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class User implements Serializable {
    /**
           * Bean Validation 中内置的 constraint
           * @Null   被注释的元素必须为 null
           * @NotNull    被注释的元素必须不为 null
           * @AssertTrue     被注释的元素必须为 true
           * @AssertFalse    被注释的元素必须为 false
           * @Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
           * @Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
           * @DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
           * @DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
           * @Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
           * @Past   被注释的元素必须是一个过去的日期
           * @Future     被注释的元素必须是一个将来的日期
           * @Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
           * Hibernate Validator 附加的 constraint
           * @NotBlank(message =)   验证字符串非null，且长度必须大于0
           * @Email  被注释的元素必须是电子邮箱地址
           * @Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
           * @NotEmpty   被注释的字符串的必须非空
           * @Range(min=,max=,message=)  被注释的元素必须在合适的范围内
           */
    private long id;
    //7~14位账号，首位必须为字母，字母数字下划线组合
    @Pattern(regexp = "^[a-zA-Z]{1}[a-zA-Z0-9_]{6,13}$",message = "{User.name.Typewrong}")
    private String name;
    //7-14位密码 首位必须为大写字母,允许为大小写字母、数字
    //这里不应该用string
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z0-9]{6,13}$",message = "{User.password.Typewrong}")
    private String password;
    //邮箱应该为email格式
    @Pattern(regexp = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$",message = "{User.email.wrong}")
    private String email;
    //11位手机号码需要满足国内手机号的开头要求
    @Pattern(regexp = "^(13[0-9]{1}|14[5|7]|15[0|1|2|3|5|6|7|8|9]18[0|1|2|3|5|6|7|8|9])[0-9]{8}$",message = "{User.phonenumber.wrong}")
    private String phonenumber;
    //15、18位身份证，最后一位可以为大小写x
    @Pattern(regexp = "([0-9]{15})|([0-9]{18})|([0-9]{17}([0-9]|X|x))",message = "{User.idcard.wrong}")
    private String idcard;
    private long create_time;
    private long update_time;
    private String salt;

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

    public String getSalt() { return salt; }

    public void setSalt(String salt) { this.salt = salt; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }
}