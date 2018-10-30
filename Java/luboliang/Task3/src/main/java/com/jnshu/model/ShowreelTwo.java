package com.jnshu.model;

public class ShowreelTwo {
    private long id ;
    private String showreel_name;
    private String showreel_one_name;
    private String state;
    private long create_at;
    private long update_at;
    private  String editor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getShowreel_name() {
        return showreel_name;
    }

    public void setShowreel_name(String showreel_name) {
        this.showreel_name = showreel_name;
    }

    public String getShowreel_one_name() {
        return showreel_one_name;
    }

    public void setShowreel_one_name(String showreel_one_name) {
        this.showreel_one_name = showreel_one_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "ShowreelTwo{" +
                "id=" + id +
                ", showreel_name='" + showreel_name + '\'' +
                ", showreel_one_name='" + showreel_one_name + '\'' +
                ", state='" + state + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", editor='" + editor + '\'' +
                '}';
    }
}
