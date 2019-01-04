package jnshu.model;

public class Author {
    private Integer authorId;

    private Long authorCreatTime;

    private Long updateTime;

    private String authorName;

    private String authorComment;

    private Integer visitorId;

    private Integer productionId;

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Long getAuthorCreatTime() {
        return authorCreatTime;
    }

    public void setAuthorCreatTime(Long authorCreatTime) {
        this.authorCreatTime = authorCreatTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    public String getAuthorComment() {
        return authorComment;
    }

    public void setAuthorComment(String authorComment) {
        this.authorComment = authorComment == null ? null : authorComment.trim();
    }

    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }
}