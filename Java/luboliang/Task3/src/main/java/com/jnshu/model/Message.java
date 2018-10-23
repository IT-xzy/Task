package com.jnshu.model;

public class Message {
    private long id;
    private String works_name;
    private long   message_time;
    private String tourist_name;
    private String state;
    private long  update_at;
    private String editor;
    private String message_contents;

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

    public long getMessage_time() {
        return message_time;
    }

    public void setMessage_time(long message_time) {
        this.message_time = message_time;
    }

    public String getTourist_name() {
        return tourist_name;
    }

    public void setTourist_name(String tourist_name) {
        this.tourist_name = tourist_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getMessage_contents() {
        return message_contents;
    }

    public void setMessage_contents(String message_contents) {
        this.message_contents = message_contents;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", works_name='" + works_name + '\'' +
                ", message_time=" + message_time +
                ", tourist_name='" + tourist_name + '\'' +
                ", state='" + state + '\'' +
                ", update_at=" + update_at +
                ", editor='" + editor + '\'' +
                ", message_contents='" + message_contents + '\'' +
                '}';
    }
}
