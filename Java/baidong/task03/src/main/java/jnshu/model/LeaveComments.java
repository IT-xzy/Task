package jnshu.model;

public class LeaveComments {
    private Long id;

    private Long worksTitle;

    private Long userName;

    private Long messageStatus;

    private String message;

    private String answer;

    private Long createAt;

    private Long updateAt;

    private Long createBy;

    private Long updateBy;

    @Override
    public String toString() {
        return "LeaveComments{" +
                "id=" + id +
                ", worksTitle=" + worksTitle +
                ", userName=" + userName +
                ", messageStatus=" + messageStatus +
                ", message='" + message + '\'' +
                ", answer='" + answer + '\'' +
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

    public Long getWorksTitle() {
        return worksTitle;
    }

    public void setWorksTitle(Long worksTitle) {
        this.worksTitle = worksTitle;
    }

    public Long getUserName() {
        return userName;
    }

    public void setUserName(Long userName) {
        this.userName = userName;
    }

    public Long getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Long messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
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