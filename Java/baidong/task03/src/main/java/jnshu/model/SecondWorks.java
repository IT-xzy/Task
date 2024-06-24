package jnshu.model;

public class SecondWorks {
    private Long id;

    private String secondName;

    private Long status;

    private Long belongFirst;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    private Long updateBy;

    @Override
    public String toString() {
        return "SecondWorks{" +
                "id=" + id +
                ", secondName='" + secondName + '\'' +
                ", status=" + status +
                ", belongFirst=" + belongFirst +
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName == null ? null : secondName.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getBelongFirst() {
        return belongFirst;
    }

    public void setBelongFirst(Long belongFirst) {
        this.belongFirst = belongFirst;
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