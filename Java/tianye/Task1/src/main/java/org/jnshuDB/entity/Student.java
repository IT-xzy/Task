package org.jnshuDB.entity;

public class Student {
    private long s_id;
    private String s_name;
    private long s_qq;
    private String s_type;
    private String s_time;
    private String s_school;
    private String s_link;
    private String s_words;
    private String s_brother;
    private String s_know;
    private long create_at;
    private long update_at;

    public long getS_id() {
        return s_id;
    }

    public void setS_id(long s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public long getS_qq() {
        return s_qq;
    }

    public void setS_qq(long s_qq) {
        this.s_qq = s_qq;
    }

    public String getS_type() {
        return s_type;
    }

    public void setS_type(String s_type) {
        this.s_type = s_type;
    }

    public String getS_time() {
        return s_time;
    }

    public void setS_time(String s_time) {
        this.s_time = s_time;
    }

    public String getS_school() {
        return s_school;
    }

    public void setS_school(String s_school) {
        this.s_school = s_school;
    }

    public String getS_link() {
        return s_link;
    }

    public void setS_link(String s_link) {
        this.s_link = s_link;
    }

    public String getS_words() {
        return s_words;
    }

    public void setS_words(String s_words) {
        this.s_words = s_words;
    }

    public String getS_brother() {
        return s_brother;
    }

    public void setS_brother(String s_brother) {
        this.s_brother = s_brother;
    }

    public String getS_know() {
        return s_know;
    }

    public void setS_know(String s_know) {
        this.s_know = s_know;
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
        return "Student{" +
                "s_id=" + s_id +
                ", s_name='" + s_name + '\'' +
                ", s_qq=" + s_qq +
                ", s_type='" + s_type + '\'' +
                ", s_time=" + s_time +
                ", s_school='" + s_school + '\'' +
                ", s_link='" + s_link + '\'' +
                ", s_words='" + s_words + '\'' +
                ", s_brother='" + s_brother + '\'' +
                ", s_know='" + s_know + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }


}
