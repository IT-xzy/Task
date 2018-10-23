package com.jnshu.model;

public class Reply {
    private long id;
    private String works_name;
    private String message_contents;
    private String reply_content;
    private long reply_time;
    private String editor;
    private long create_at;
    private long update_at;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWorks_name() {
        return works_name;
    }

    public void setWorks_name(String works_name) {
        this.works_name = works_name;
    }

    public String getMessage_contents() {
        return message_contents;
    }

    public void setMessage_contents(String message_contents) {
        this.message_contents = message_contents;
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content;
    }

    public long getReply_time() {
        return reply_time;
    }

    public void setReply_time(long reply_time) {
        this.reply_time = reply_time;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", works_name='" + works_name + '\'' +
                ", message_contents='" + message_contents + '\'' +
                ", reply_content='" + reply_content + '\'' +
                ", reply_time=" + reply_time +
                ", editor='" + editor + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }
}
