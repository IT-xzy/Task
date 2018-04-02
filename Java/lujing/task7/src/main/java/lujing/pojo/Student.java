package lujing.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {
    
    private Integer id;

    private String name;

    private String qqNum;

    private String type;

    private @DateTimeFormat(pattern = "yyyy-MM-dd") Date perTime;

    private String gradSchool;

    private String dailyLink;

    private String statement;

    private String presenter;

    private String learnFrom;

    private @DateTimeFormat(pattern = "yyyy-MM-dd") Long createAt;

    private @DateTimeFormat(pattern = "yyyy-MM-dd") Long updateAt;

    private String pic;
    

    public Student(Integer id, String name, String qqNum, String type, Date perTime, String gradSchool, String dailyLink, String statement, String presenter, String learnFrom, Long createAt, Long updateAt, String pic) {
        this.id = id;
        this.name = name;
        this.qqNum = qqNum;
        this.type = type;
        this.perTime = perTime;
        this.gradSchool = gradSchool;
        this.dailyLink = dailyLink;
        this.statement = statement;
        this.presenter = presenter;
        this.learnFrom = learnFrom;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.pic = pic;
    }

    public Student() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getQqNum() {
        return qqNum;
    }

    public void setQqNum(String qqNum) {
        this.qqNum = qqNum == null ? null : qqNum.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getPerTime() {
        return perTime;
    }

    public void setPerTime(Date perTime) {
        this.perTime = perTime;
    }

    public String getGradSchool() {
        return gradSchool;
    }

    public void setGradSchool(String gradSchool) {
        this.gradSchool = gradSchool == null ? null : gradSchool.trim();
    }

    public String getDailyLink() {
        return dailyLink;
    }

    public void setDailyLink(String dailyLink) {
        this.dailyLink = dailyLink == null ? null : dailyLink.trim();
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement == null ? null : statement.trim();
    }

    public String getPresenter() {
        return presenter;
    }

    public void setPresenter(String presenter) {
        this.presenter = presenter == null ? null : presenter.trim();
    }

    public String getLearnFrom() {
        return learnFrom;
    }

    public void setLearnFrom(String learnFrom) {
        this.learnFrom = learnFrom == null ? null : learnFrom.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }
}