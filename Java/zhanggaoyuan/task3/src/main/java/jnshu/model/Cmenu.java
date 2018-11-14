package jnshu.model;

import java.util.List;

public class Cmenu {
    private Integer cmenuId;

    private String cmenuName;

    private Long creatTime;

    private Long updateTime;

    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getCmenuId() {
        return cmenuId;
    }

    public void setCmenuId(Integer cmenuId) {
        this.cmenuId = cmenuId;
    }

    public String getCmenuName() {
        return cmenuName;
    }

    public void setCmenuName(String cmenuName) {
        this.cmenuName = cmenuName == null ? null : cmenuName.trim();
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}