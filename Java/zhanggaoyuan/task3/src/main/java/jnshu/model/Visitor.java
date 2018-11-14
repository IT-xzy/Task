package jnshu.model;

import java.util.List;

public class Visitor {
    private Integer visitorId;

    private Long visitorCreatTime;

    private Long updateTime;

    private String visitorName;

    private String visitorComment;

    private Boolean visitorChoiceness;

    private Integer productionId;

    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Long getVisitorCreatTime() {
        return visitorCreatTime;
    }

    public void setVisitorCreatTime(Long visitorCreatTime) {
        this.visitorCreatTime = visitorCreatTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName == null ? null : visitorName.trim();
    }

    public String getVisitorComment() {
        return visitorComment;
    }

    public void setVisitorComment(String visitorComment) {
        this.visitorComment = visitorComment == null ? null : visitorComment.trim();
    }

    public Boolean getVisitorChoiceness() {
        return visitorChoiceness;
    }

    public void setVisitorChoiceness(Boolean visitorChoiceness) {
        this.visitorChoiceness = visitorChoiceness;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }
}