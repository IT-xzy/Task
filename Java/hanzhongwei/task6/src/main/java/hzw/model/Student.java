package hzw.model;

import java.io.Serializable;

public class Student implements Serializable {
    private Long sId;
    private String sName;
    private Integer QQ;
    private String sType;
    private String sTime;
    private String sSchool;
    private String sNumber;
    private String sDaily;
    private String sWish;
    private String sCoach;
    private String sWhence;
    private Long create_at;
    private Long update_at;

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getQQ() {
        return QQ;
    }

    public void setQQ(Integer QQ) {
        this.QQ = QQ;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getsSchool() {
        return sSchool;
    }

    public void setsSchool(String sSchool) {
        this.sSchool = sSchool;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getsDaily() {
        return sDaily;
    }

    public void setsDaily(String sDaily) {
        this.sDaily = sDaily;
    }

    public String getsWish() {
        return sWish;
    }

    public void setsWish(String sWish) {
        this.sWish = sWish;
    }

    public String getsCoach() {
        return sCoach;
    }

    public void setsCoach(String sCoach) {
        this.sCoach = sCoach;
    }

    public String getsWhence() {
        return sWhence;
    }

    public void setsWhence(String sWhence) {
        this.sWhence = sWhence;
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

    @Override
    public String toString(){
        return "Student [ id = "+sId+","+
                "name = "+sName+","+
                "QQ = "+QQ+","+
                "type = "+sType+","+
                "time = "+sTime+","+
                "school = "+sSchool+","+
                "sNumber = "+sNumber+","+
                "sDaily = "+sDaily+","+
                "sWish = "+sWish+","+
                "sCoach = "+sCoach+","+
                "sWhence = "+sWhence+","+
                "create_at = "+create_at+","+
                "update_at = "+update_at+"]\n";
    }
}
