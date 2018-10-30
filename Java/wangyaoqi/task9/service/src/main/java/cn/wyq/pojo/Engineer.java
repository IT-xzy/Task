package cn.wyq.pojo;

import org.oasisopen.sca.annotation.Remotable;

import java.io.Serializable;

public class Engineer implements Serializable {
    private static final long serialVersionUID = 1883838732853579826L;

    public int id;
    public String direction;
    public String photo;
    public String type;
    public short threshold;
    public short difficult;
    public long createTime;
    public int demand;
    public int oneYear;
    public int threeYear;
    public int fiveYear;
    public int tenYear;
    public int studyNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getThreshold() {
        return threshold;
    }

    public void setThreshold(short threshold) {
        this.threshold = threshold;
    }

    public short getDifficult() {
        return difficult;
    }

    public void setDifficult(short difficult) {
        this.difficult = difficult;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getOneYear() {
        return oneYear;
    }

    public void setOneYear(int oneYear) {
        this.oneYear = oneYear;
    }

    public int getThreeYear() {
        return threeYear;
    }

    public void setThreeYear(int threeYear) {
        this.threeYear = threeYear;
    }

    public int getFiveYear() {
        return fiveYear;
    }

    public void setFiveYear(int fiveYear) {
        this.fiveYear = fiveYear;
    }

    public int getTenYear() {
        return tenYear;
    }

    public void setTenYear(int tenYear) {
        this.tenYear = tenYear;
    }

    public int getStudyNumber() {
        return studyNumber;
    }

    public void setStudyNumber(int studyNumber) {
        this.studyNumber = studyNumber;
    }

    @Override
    public String toString(){
        return "Engineer{"+
                "id="+id+
                ",photo='"+photo+'\''+
                ",type='"+type+'\''+
                ",threshold="+threshold+
                ",difficult="+difficult+
                ",demand="+demand+
                ",createTime="+createTime+
                ",oneYear="+oneYear+
                ",threeYear="+threeYear+
                ",fiveYear="+fiveYear+
                ",tenYear="+tenYear+
                ",studyNumber="+studyNumber+
                "}";
    }
}
