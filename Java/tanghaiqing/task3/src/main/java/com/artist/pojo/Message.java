package com.artist.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

public class Message {
    @Null
    private Integer messageId;
    @NotBlank(message = "游客名不能为空")
    private String nick;
    @NotBlank(message = "留言信息不能为空")
    @Size(min = 1,max = 150,message = "留言信息长度在1-150之间")
    private String message;
    private Integer productionId;
    private String type;
    private String selection;
    private Integer replyId;
    private Long createTime;
    private Long updateTime;

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getProductionId() {
        return productionId;
    }

    public void setProductionId(Integer productionId) {
        this.productionId = productionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", nick='" + nick + '\'' +
                ", message='" + message + '\'' +
                ", productionId='" + productionId + '\'' +
                ", type='" + type + '\'' +
                ", selection='" + selection + '\'' +
                ", replyId=" + replyId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
