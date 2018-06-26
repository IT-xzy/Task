package po;

import java.util.Date;

public class User {
    //表示ID
    private int id;
    private String name;
    private String QQ;
    private String major;
    private Date startTime;
    private String school;
    private int onlint_id;
    private String daily_linke;
    private String desire;
    private String bre;
    private String know_from;
    private Date create_at;
    private Date update_at;

    public int getId(){
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return QQ;
    }

    public void setQq(String QQ) {
        this.QQ = QQ;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int onlint_id() {
        return onlint_id;
    }

    public void setOnlint_id(int onlint_id) {
        this.onlint_id = onlint_id();
    }
    public String getdaily_linke(){
        return daily_linke;
    }

    public void setDaily_linke(String daily_linke) {
        this.daily_linke = daily_linke;
    }

    public String getDesire() {
        return desire;
    }

    public void setDesire(String desire) {
        this.desire = desire;
    }

    public String getBre() {
        return bre;
    }

    public void setBre(String bre) {
        this.bre = bre;
    }

    public String getKnow_from() {
        return know_from;
    }

    public void setKnow_from(String know_from) {
        this.know_from = know_from;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }
    @Override
    public String toString() {
        return "UserDao.xml{id="+ id +",name="+ name +",QQ="+ QQ +",major="+ major +",starTime="+ startTime +",school="+ school + ",onlint_id="+ onlint_id + ",daily_linke="+ daily_linke +"," +
                "desire="+ desire +",bre="+ bre +",know_from="+ know_from +",create_at"+ create_at +",update_at"+ update_at +"}";

    }
}
