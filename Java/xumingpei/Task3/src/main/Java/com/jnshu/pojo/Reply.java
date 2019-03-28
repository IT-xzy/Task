package com.jnshu.pojo;

public class Reply {
    private Long replyId;

    private String replyName;

    private String replyContent;

    private Long createAt;

    private Long updateAt;

    private String updateBy;

    private String createBy;

    private Long msgId;

    public Long getReplyId() {
        return replyId;
    }

    public void setReplyId(long replyId) {
        this.replyId = replyId;
    }

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(long msgId) {
        this.msgId = msgId;
    }

    public String getReplyName() {
        return replyName;
    }

    public void setReplyName(String replyName) {
        this.replyName = replyName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyName='" + replyName + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", updateBy='" + updateBy + '\'' +
                ", createBy='" + createBy + '\'' +
                ", msgId=" + msgId +
                '}';
    }
}