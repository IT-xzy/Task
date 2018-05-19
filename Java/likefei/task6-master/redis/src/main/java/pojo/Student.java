package pojo;

import java.io.Serializable;

public class Student implements Serializable{
    public Student(){}
    public Student(Integer id,String name,Long qq,String job,String school,String url){
        this.id = id;
        this.name = name;
        this.qq = qq;
        this.job = job;
        this.school = school;
        this.url = url;
    }

    private Integer id;
    private String name;
    private Long qq;
    private String job;
    private String school;
    private String url;
    private long createtime;
    private long updatetime;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", job='" + job + '\'' +
                ", school='" + school + '\'' +
                ", url='" + url + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", image='" + image + '\'' +
                '}';
    }
}
