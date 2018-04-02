package POJO;

import java.math.BigInteger;

public class Student1 {
    private int ID;
    private String name;
    private BigInteger QQ;
    private String onlineID;
    private String time_of_enrollment;
    private String graduate_institutions;
    private String report_link;
    private String swear;
    private String hearfrom;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getQQ() {
        return QQ;
    }

    public void setQQ(BigInteger QQ) {
        this.QQ = QQ;
    }

    public String getOnlineID() {
        return onlineID;
    }

    public void setOnlineID(String onlineID) {
        this.onlineID = onlineID;
    }

    public String getTime_of_enrollment() {
        return time_of_enrollment;
    }

    public void setTime_of_enrollment(String time_of_enrollment) {
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

    @Override
    public String toString() {
        return "Student1{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", QQ=" + QQ +
                ", onlineID='" + onlineID + '\'' +
                ", time_of_enrollment='" + time_of_enrollment + '\'' +
                ", graduate_institutions='" + graduate_institutions + '\'' +
                ", report_link='" + report_link + '\'' +
                ", swear='" + swear + '\'' +
                ", hearfrom='" + hearfrom + '\'' +
                '}';
    }

}
