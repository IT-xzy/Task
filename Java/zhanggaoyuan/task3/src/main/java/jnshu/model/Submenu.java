package jnshu.model;

public class Submenu {
    private Integer submenuId;

    private String submenuName;

    private Integer cmenuId;

    private Long creatTime;

    private Long updateTime;

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public String getSubmenuName() {
        return submenuName;
    }

    public void setSubmenuName(String submenuName) {
        this.submenuName = submenuName == null ? null : submenuName.trim();
    }

    public Integer getCmenuId() {
        return cmenuId;
    }

    public void setCmenuId(Integer cmenuId) {
        this.cmenuId = cmenuId;
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