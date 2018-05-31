package com.ptteng.model;

public class Student {
    private long id;
    private String name;
    private int sta;
    private long updated_at;
    private long created_at;
    private String introduction;
    private String occupation;
    private String image;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSta() {
        return sta;
    }

    public void setSta(int sta) {
        this.sta = sta;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Student(long id, String name, int sta, String introduction, String occupation, String image) {
        this.id = id;
        this.name = name;
        this.sta = sta;
        this.introduction = introduction;
        this.occupation = occupation;
        this.image = image;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sta=" + sta +
                ", updated_at=" + updated_at +
                ", created_at=" + created_at +
                ", introduction='" + introduction + '\'' +
                ", occupation='" + occupation + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}