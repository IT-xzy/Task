package jnshu.model;

public class FirstWorks {
    private Long id;

    private String firstName;

    private Long status;

    private Long stateAt;

    private Long updateAt;

    private Long stateBy;

    private Long updateBy;

    @Override
    public String toString() {
        return "FirstWorks{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", status='" + status + '\'' +
                ", stateAt=" + stateAt +
                ", updateAt=" + updateAt +
                ", stateBy='" + stateBy + '\'' +
                ", updateBy='" + updateBy + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName == null ? null : firstName.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStateAt() {
        return stateAt;
    }

    public void setStateAt(Long stateAt) {
        this.stateAt = stateAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getCreateBy() {
        return stateBy;
    }

    public void setCreateBy(Long createBy) {
        this.stateBy = createBy;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}