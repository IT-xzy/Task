package pojo;


import com.fasterxml.jackson.core.SerializableString;
import validator.ValidatorGroup1;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Student implements Serializable{
    private static final long serialVersionUID = 1L;
    //必须为数字
    //这里不该用string
//    @Pattern(regexp = "^[0-9]+$",message = "{Student.id.wrong}")
    @NotNull(message = "{Student.id.isNull",groups = {ValidatorGroup1.class})
    private Integer id;
    //必须为中文
    @Pattern(regexp = "[\\u4e00-\\u9fa5]+",message = "{Student.name.wrong}")
    private String name;
    //必须为10000后的数字
    //这里不该用string
//    @Pattern(regexp = "^[1-9]{1}[0-9]{4,}$",message = "{Student.qq.wrong}")
    @Min(value = 10000,message = "{Student.qq.tooshort}")
    @NotNull(message = "{Student.qq.isNull}")
    private Long qq;
    //任意大小写英文（可能有特殊符号需求，比如C+）
    @Pattern(regexp = "^[a-zA-Z]{1,}[/+]{0,}$",message = "{Student.job.wrong}")
    private String job;
    //必须为中文
    @Pattern(regexp = "[\\u4e00-\\u9fa5]+",message = "{Student.school.wrong}")
    private String school;
    //必须为网址格式
    @Pattern(regexp = "[a-zA-Z]+://[^\\s]*",message = "{Student.url.wrong}")
    private String url;
    //必须为十三位数字
//    @Pattern(regexp = "^[0-9]{13}$",message = "{Student.createtime.wrong")
    private long createtime;
    //必须为十三位数字
//    @Pattern(regexp = "^[0-9]{13}$",message = "{Student.updatetime.wrong")
    private long updatetime;
    //必须为相对路径（这里用不用正则？？）
    private String image;

    public Integer getId() { return id;
    }

    public void setId(Integer id) { this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(long createtime) {
        this.createtime = createtime;
    }

    public long getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(long updatetime) {
        this.updatetime = updatetime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
