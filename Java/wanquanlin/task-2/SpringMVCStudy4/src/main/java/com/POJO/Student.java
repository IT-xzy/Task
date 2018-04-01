package com.POJO;

public class Student {
        private Long ID;
        private String name;
        private long QQ;
        private String onlineID;
        private Long time_of_enrollment;
        private String graduate_institutions;
        private String report_link;
        private String swear;
        private String hearfrom;
        private Long create_at;
        private Long update_at;

    public Student() {
    }



    public Student(Long ID, String name, long QQ,
                   String onlineID, Long time_of_enrollment,
                   String graduate_institutions, String report_link,
                   String swear, String hearfrom, Long create_at, Long update_at) {
        this.ID = ID;
        this.name = name;
        this.QQ = QQ;
        this.onlineID = onlineID;
        this.time_of_enrollment = time_of_enrollment;
        this.graduate_institutions = graduate_institutions;
        this.report_link = report_link;
        this.swear = swear;
        this.hearfrom = hearfrom;
        this.create_at = create_at;
        this.update_at = update_at;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getQQ() {
        return QQ;
    }

    public void setQQ(long QQ) {
        this.QQ = QQ;
    }

    public String getOnlineID() {
        return onlineID;
    }

    public void setOnlineID(String onlineID) {
        this.onlineID = onlineID;
    }

    public Long getTime_of_enrollment() {
        return time_of_enrollment;
    }

    public void setTime_of_enrollment(Long time_of_enrollment) {
        this.time_of_enrollment = time_of_enrollment;
    }

    public String getGraduate_institutions() {
        return graduate_institutions;
    }

    public void setGraduate_institutions(String graduate_institutions) {
        this.graduate_institutions = graduate_institutions;
    }

    public String getReport_link() {
        return report_link;
    }

    public void setReport_link(String report_link) {
        this.report_link = report_link;
    }

    public String getSwear() {
        return swear;
    }

    public void setSwear(String swear) {
        this.swear = swear;
    }

    public String getHearfrom() {
        return hearfrom;
    }

    public void setHearfrom(String hearfrom) {
        this.hearfrom = hearfrom;
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
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", QQ=" + QQ +
                ", onlineID='" + onlineID + '\'' +
                ", time_of_enrollment=" + time_of_enrollment +
                ", graduate_institutions='" + graduate_institutions + '\'' +
                ", report_link='" + report_link + '\'' +
                ", swear='" + swear + '\'' +
                ", hearfrom='" + hearfrom + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}

