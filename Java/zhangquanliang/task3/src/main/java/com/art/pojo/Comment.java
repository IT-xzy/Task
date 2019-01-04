package com.art.pojo;

public class Comment {
    private Integer id;

    private String nick;

    private Integer workId;

    private String fromBy;

    private String toBy;

    private Boolean type;

    private Boolean status;

    private String content;

    private Long createAt;

    private Long updateAt;

    public Comment(Integer id, String nick, Integer workId, String fromBy, String toBy, Boolean type, Boolean status, String content, Long createAt, Long updateAt) {
        this.id = id;
        this.nick = nick;
        this.workId = workId;
        this.fromBy = fromBy;
        this.toBy = toBy;
        this.type = type;
        this.status = status;
        this.content = content;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public Integer getWorkId() {
        return workId;
    }

    public void setWorkId(Integer workId) {
        this.workId = workId;
    }

    public String getFromBy() {
        return fromBy;
    }

    public void setFromBy(String fromBy) {
        this.fromBy = fromBy == null ? null : fromBy.trim();
    }

    public String getToBy() {
        return toBy;
    }

    public void setToBy(String toBy) {
        this.toBy = toBy == null ? null : toBy.trim();
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Comment{");
        sb.append("id=").append(id);
        sb.append(", nick='").append(nick).append('\'');
        sb.append(", workId=").append(workId);
        sb.append(", fromBy='").append(fromBy).append('\'');
        sb.append(", toBy='").append(toBy).append('\'');
        sb.append(", type=").append(type);
        sb.append(", status=").append(status);
        sb.append(", content='").append(content).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append('}');
        return sb.toString();
    }
}