package com.jnshu.model;

public class ShowreelOne {
    private long id;
    private long create_at;
    private long update_at;
    private String showreel_name;
    private String state;
    private String editor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getShowreel_name() {
        return showreel_name;
    }

    public void setShowreel_name(String showreel_name) {
        this.showreel_name = showreel_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "ShowreelOne{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", showreel_name='" + showreel_name + '\'' +
                ", state='" + state + '\'' +
                ", editor='" + editor + '\'' +
                '}';
    }
}
