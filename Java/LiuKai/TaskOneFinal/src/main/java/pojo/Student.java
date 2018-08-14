package pojo;

import org.apache.ibatis.type.Alias;

import java.sql.Date;


public class Student {
/*
*  2018.06.20
*  相关yuan元素设置为private
*
*  1，id是否要设置getset方法
*  2.JavaBean中的属性命名我们习惯于驼峰命名法，在数据库中更常用下划线命名法，因此后续需要在xml中使用result mapper方法
*
*
* */

    private long id;
    //姓名
    private String stuName;
    //qq
    private String qqNum;
    //课程
    private String course;
    //预计入学时间
    private Date comeTime;
    //毕业院校
    private String graSchool;
    //线上学号
    private String jnsNum;
    //日报连接
    private String dailyPaper;
    //立愿
    private String wish;
    //师兄
    private String jnsBro;
    //获知途径
    private String knFrom;
    //创建时间
    private long createTime;
//    更新时间
    private long updateTime;

public  Student(long id, String stuName, String qqNum, String course,Date comeTime,
                    String graSchool, String jnsNum, String dailyPaper, String wish, String jnsBro,
                    String knFrom, long createTime, long updateTime
){
    this.id=id;
    this.stuName=stuName;
    this.qqNum=qqNum;
    this.course=course;
    this.comeTime=comeTime;
    this.graSchool=graSchool;
    this.jnsNum=jnsNum;
    this.dailyPaper=dailyPaper;
    this.wish=wish;
    this.jnsBro=jnsBro;
    this.knFrom=knFrom;
    this.createTime=createTime;
    this.updateTime=updateTime;
}
 public Student(){}


    public long getId() {
        return id;
    }

    public Student setId(long id) {
        this.id = id;
        return this;
    }

    public String getStuName() {
        return stuName;
    }

    public Student setStuName(String stuName) {
        this.stuName = stuName;
        return this;
    }

    public String getQqNum() {
        return qqNum;
    }

    public Student setQqNum(String qqNum) {
        this.qqNum = qqNum;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public Student setCourse(String course) {
        this.course = course;
        return this;
    }

    public Date getComeTime() {
        return comeTime;
    }

    public Student setComeTime(Date comeTime) {
        this.comeTime = comeTime;
        return this;
    }

    public String getGraSchool() {
        return graSchool;
    }

    public Student setGraSchool(String graSchool) {
        this.graSchool = graSchool;
        return this;
    }

    public String getJnsNum() {
        return jnsNum;
    }

    public Student setJnsNum(String jnsNum) {
        this.jnsNum = jnsNum;
        return this;
    }

    public String getDailyPaper() {
        return dailyPaper;
    }

    public Student setDailyPaper(String dailyPaper) {
        this.dailyPaper = dailyPaper;
        return this;
    }

    public String getWish() {
        return wish;
    }

    public Student setWish(String wish) {
        this.wish = wish;
        return this;
    }

    public String getJnsBro() {
        return jnsBro;
    }

    public Student setJnsBro(String jnsBro) {
        this.jnsBro = jnsBro;
        return this;
    }

    public String getKnFrom() {
        return knFrom;
    }

    public Student setKnFrom(String knFrom) {
        this.knFrom = knFrom;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Student setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public Student setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    @Override
    public String toString() {
        return "学生[ID=" +id +
                " 姓名="+stuName+
                " QQ="+qqNum+
                " 课程="+course+
                "]";
    }
}

