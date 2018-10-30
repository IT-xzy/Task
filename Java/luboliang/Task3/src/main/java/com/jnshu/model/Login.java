package com.jnshu.model;

public class Login {
    private long id;
    private long create_at;
    private long update_at;
    private String user_name;
    private String password;
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

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", editor='" + editor + '\'' +
                '}';
    }
}
