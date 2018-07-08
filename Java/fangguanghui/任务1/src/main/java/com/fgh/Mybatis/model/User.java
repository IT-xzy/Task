package com.fgh.Mybatis.model;
import com.fgh.Mybatis.Tool.TimeReversal;
import org.springframework.stereotype.Component;


public class User {
    private int id;
    private String username;
    private String QQ;
    private String type;
    private long joinTime;
    private String school;
    private String onlineId;
    private String daily;
    private String description;
    private String counsellor;
    private String way;
    private long create_at;
    private long update_at;
    private TimeReversal TimeReveral;

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

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(long joinTime) {
        this.joinTime = joinTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getOnlineId() {
        return onlineId;
    }

    public void setOnlineId(String onlineId) {
        this.onlineId = onlineId;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCounsellor() {
        return counsellor;
    }

    public void setCounsellor(String counsellor) {
        this.counsellor = counsellor;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }



    @Override
    public String toString(){
        return " user="+username+" id="+id+" QQ="+QQ+" type="+type+
                " joinTime="+TimeReversal.longtoString(joinTime)+
                " school="+school+" onlineId="+onlineId+" daily="+daily+
                " description="+description+ " counsellor="+counsellor+
                " way="+way+" create_at="+TimeReversal.longtoString(create_at)+
                " update_at="+TimeReversal.longtoString(update_at);
    }
}
