package jnshu.pojo;

import java.util.List;

public class StudentInfo implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String studentName;
    private Integer qq;
    private String learnType;
    private String joinTime;
    private String school;
    private Integer studentID;
    private String link;
    private String motto;
    private String brother;
    private String knowFrom;
    private List<StudentInfo> lists;

//    分页用的变量
    private Integer pageCount=0;

    public StudentInfo(Integer id, String studentName, Integer qq, String learnType, String joinTime, String school, Integer studentID, String link, String motto, String brother, String knowFrom) {
        this.id = id;
        this.studentName = studentName;
        this.qq = qq;
        this.learnType = learnType;
        this.joinTime = joinTime;
        this.school = school;
        this.studentID = studentID;
        this.link = link;
        this.motto = motto;
        this.brother = brother;
        this.knowFrom = knowFrom;
    }

    public StudentInfo() {
        super();
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", qq=" + qq +
                ", learnType='" + learnType + '\'' +
                ", joinTime='" + joinTime + '\'' +
                ", school='" + school + '\'' +
                ", studentID=" + studentID +
                ", link='" + link + '\'' +
                ", motto='" + motto + '\'' +
                ", brother='" + brother + '\'' +
                ", knowFrom='" + knowFrom + '\'' +
                ", lists=" + lists +
                ", pageCount=" + pageCount +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String student_name) {
        this.studentName = student_name;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getLearnType() {
        return learnType;
    }

    public void setLearnType(String learn_type) {
        this.learnType = learn_type;
    }

    public String getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(String join_time) {
        this.joinTime = join_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String shcool) {
        this.school = shcool;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer student_id) {
        this.studentID = student_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String bro) {
        this.brother = bro;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String konw_from) {
        this.knowFrom = konw_from;
    }

    public List<StudentInfo> getLists() {
        return lists;
    }

    public void setLists(List<StudentInfo> lists) {
        this.lists = lists;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}






