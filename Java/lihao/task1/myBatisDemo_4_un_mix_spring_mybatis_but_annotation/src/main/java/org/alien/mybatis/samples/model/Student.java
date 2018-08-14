package org.alien.mybatis.samples.model;

/**
 * @author lihoo
 * @Title: Student
 * @ProjectName myBatisDemo_4
 * @Description: entity-class
 * @date 2018/7/1214:38
 */

@SuppressWarnings("unused")
public class Student {
    private int id;
    private String username;
    private int qq_num;
    private String study_type;
    private int study_time;
    private String school;
    private String study_id;
    private String daily_link;
    private String promise;
    private String teach_bro;
    private String know_us_from;
    private int create_at;
    private int update_at;

    public Student() {

    }

    public Student(int id, String username
                    , int qq_num, String study_type,
                   int study_time, String school, String study_id,
                   String daily_link, String promise, String teach_bro,
                   String know_us_from, int create_at, int update_at
    ) {
        this.id = id;
        this.username = username;
        this.qq_num = qq_num;
        this.study_type = study_type;
        this.study_time = study_time;
        this.school = school;
        this.study_id = study_id;
        this.daily_link = daily_link;
        this.promise = promise;
        this.teach_bro = teach_bro;
        this.know_us_from = know_us_from;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getQq_num() {
        return qq_num;
    }

    public void setQq_num(int qq_num) {
        this.qq_num = qq_num;
    }

    public String getStudy_type() {
        return study_type;
    }

    public void setStudy_type(String study_type) {
        this.study_type = study_type;
    }

    public int getStudy_time() {
        return study_time;
    }

    public void setStudy_time(int study_time) {
        this.study_time = study_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getStudy_id() {
        return study_id;
    }

    public void setStudy_id(String study_id) {
        this.study_id = study_id;
    }

    public String getDaily_link() {
        return daily_link;
    }

    public void setDaily_link(String daily_link) {
        this.daily_link = daily_link;
    }

    public String getPromise() {
        return promise;
    }

    public void setPromise(String promise) {
        this.promise = promise;
    }

    public String getTeach_bro() {
        return teach_bro;
    }

    public void setTeach_bro(String teach_bro) {
        this.teach_bro = teach_bro;
    }

    public String getKnow_us_from() {
        return know_us_from;
    }

    public void setKnow_us_from(String know_us_from) {
        this.know_us_from = know_us_from;
    }

    public int getCreate_at() {
        return create_at;
    }

    public void setCreate_at(int create_at) {
        this.create_at = create_at;
    }

    public int getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(int update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ",username='" + username + '\'' +
                ",qq_num='" + qq_num + '\'' +
                ",study_type='" + study_type + '\'' +
                ",study_time='" + study_time + '\'' +
                ",school='" + school + '\'' +
                ",study_id='" +study_id + '\'' +
                ",daily_link='" + daily_link + '\'' +
                ",promise='" + promise + '\'' +
                ",teach_bro='" +teach_bro + '\'' +
                ",know_us_from='" + know_us_from + '\'' +
                ",create_at='" + create_at + '\'' +
                ",update_at='" + update_at + '\'' +
                '}';
    }
}
