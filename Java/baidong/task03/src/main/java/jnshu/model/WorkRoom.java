package jnshu.model;

public class WorkRoom {
    private Long id;

    private String name;

    private Long status;

    private String workPicture;

    private String text;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    private Long updateBy;

    @Override
    public String toString() {
        return "WorkRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", workPicture='" + workPicture + '\'' +
                ", text='" + text + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", createBy=" + createBy +
                ", updateBy=" + updateBy +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public String getWorkPicture() {
        return workPicture;
    }

    public void setWorkPicture(String workPicture) {
        this.workPicture = workPicture == null ? null : workPicture.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
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

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}