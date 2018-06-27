package com.jnshu.model;

import com.jnshu.validation.ValidationInsert;
import com.jnshu.validation.ValidationUpdate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;

/*
* JSR提供的校验注解：
@Null   被注释的元素必须为 null
@NotNull    被注释的元素必须不为 null
@AssertTrue     被注释的元素必须为 true
@AssertFalse    被注释的元素必须为 false
@Min(value)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@Size(max=, min=)   被注释的元素的大小必须在指定的范围内
@Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
@Past   被注释的元素必须是一个过去的日期
@Future     被注释的元素必须是一个将来的日期
@Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式

Hibernate Validator提供的校验注解：
@NotBlank(message =)   验证字符串非null，且长度必须大于0
@Email  被注释的元素必须是电子邮箱地址
@Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
@NotEmpty   被注释的字符串的必须非空
@Range(min=,max=,message=)  被注释的元素必须在合适的范围内
*/

public class User {
    //当属性值为基本类型int时,是不能为空的,要空属性必须为对象类型 Integer
    private Integer id;
    //姓名
    @Size(min = 1, max = 10, message = "{user.name.length.error}", groups = {ValidationInsert.class, ValidationUpdate.class})
    private String username;
    //qq
    private Integer qq;
    //修真类型
    @NotBlank(groups = ValidationInsert.class, message = "修真类型不能为空")
    @Pattern(regexp = "^UI|JAVA|WEB|$", message = "{user.profession.include}", groups = {ValidationInsert.class, ValidationUpdate.class})
    private String profession;
    //预计入学时间
    @NotNull(message = "入学时间不能为空,Key/value格式为 2018-00-00 00:00:00,json为long类型的数字", groups = {ValidationInsert.class})
    private Long join_date;
    //毕业院校
    private String school;
    //线上id
    @Min(value = 1, message = "线上id为大于0的数字", groups = {ValidationInsert.class, ValidationUpdate.class})
    private Integer online_id;
    //日报连接
    private String daily_url;
    //立愿
    private String declaration;
    //辅导师兄
    private String counselor;
    //创建时间
    @NotNull(message = "创建时间不能为空,Key/value格式为 2018-00-00 00:00:00,json为long类型的数字", groups = {ValidationInsert.class})
    private Long create_time;
    //更新时间
    @NotNull(message = "更新时间不能为空,Key/value格式为 2018-00-00 00:00:00,json为long类型的数字", groups = {ValidationInsert.class})
    private Long update_time;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", qq='" + qq + '\'' +
                ", profession='" + profession + '\'' +
                ", join_date=" + join_date +
                ", school='" + school + '\'' +
                ", online_id='" + online_id + '\'' +
                ", daily_url='" + daily_url + '\'' +
                ", declaration='" + declaration + '\'' +
                ", counselor='" + counselor + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Long getJoin_date() {
        return join_date;
    }

    public void setJoin_date(Long join_date) {
        this.join_date = join_date;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getOnline_id() {
        return online_id;
    }

    public void setOnline_id(Integer online_id) {
        this.online_id = online_id;
    }

    public String getDaily_url() {
        return daily_url;
    }

    public void setDaily_url(String daily_url) {
        this.daily_url = daily_url;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getCounselor() {
        return counselor;
    }

    public void setCounselor(String counselor) {
        this.counselor = counselor;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }
}
