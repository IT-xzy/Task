package cn.wp.model;

public class Message {
    private Long id;

    private Long workTitle;

    private String userName;

    private Long state;

    private Long createAt;

    private Long updateAt;

    private Long updateBy;

    private String message;

    private Long createBy;

    private Long parentId;

    private Byte  type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWorkTitle() {
        return workTitle;
    }

    public void setWorkTitle(Long workTitle) {
        this.workTitle = workTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
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

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getparentId() {
        return parentId;
    }

    public void setparentId(Long parentId) {
        this.parentId = parentId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", workTitle=" + workTitle +
                ", userName='" + userName + '\'' +
                ", state=" + state +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy=" + updateBy +
                ", message='" + message + '\'' +
                ", createBy=" + createBy +
                ", parentId=" + parentId +
                ", type=" + type +
                '}';
    }
}