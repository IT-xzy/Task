package com.tiles.model;

public class Home {
    private long id;
    private int online_num;
    private int find_job;
    private String consultant;
    private String introduce;
    private String img_path;
    private long create_at;
    private long update_at;

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", online_num=" + online_num +
                ", find_job=" + find_job +
                ", consultant='" + consultant + '\'' +
                ", introduce='" + introduce + '\'' +
                ", img_path='" + img_path + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getOline_num() {
        return online_num;
    }

    public void setOline_num(int oline_num) {
        this.online_num = oline_num;
    }

    public int getFind_job() {
        return find_job;
    }

    public void setFind_job(int find_job) {
        this.find_job = find_job;
    }

    public String getConsultant() {
        return consultant;
    }

    public void setConsultant(String consultant) {
        this.consultant = consultant;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        this.img_path = img_path;
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
}
