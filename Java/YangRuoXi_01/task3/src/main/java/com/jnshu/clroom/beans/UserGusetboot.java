package com.jnshu.clroom.beans;

public class UserGusetboot {
    private Integer id;

    private String guestbook;

    private String painting;

    private String banner;

    private String studio;

    private String track;

    public UserGusetboot(Integer id, String guestbook, String painting, String banner, String studio, String track) {
        this.id = id;
        this.guestbook = guestbook;
        this.painting = painting;
        this.banner = banner;
        this.studio = studio;
        this.track = track;
    }

    public UserGusetboot() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGuestbook() {
        return guestbook;
    }

    public void setGuestbook(String guestbook) {
        this.guestbook = guestbook == null ? null : guestbook.trim();
    }

    public String getPainting() {
        return painting;
    }

    public void setPainting(String painting) {
        this.painting = painting == null ? null : painting.trim();
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio == null ? null : studio.trim();
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track == null ? null : track.trim();
    }
}