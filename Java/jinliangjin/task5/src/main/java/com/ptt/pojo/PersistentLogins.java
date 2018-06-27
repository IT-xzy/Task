package com.ptt.pojo;

import java.util.Date;

public class PersistentLogins {
    private Integer id;
    private String username;//账号
    private String series;//UUID.randomUUID().toString()生成的String类型的UUID
    private String token;//token
    private Date validtime;//过期时间

    public PersistentLogins(Integer id, String username, String series, String token, Date validtime) {
        this.id = id;
        this.username = username;
        this.series = series;
        this.token = token;
        this.validtime = validtime;
    }

    public PersistentLogins() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series == null ? null : series.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public Date getValidtime() {
        return validtime;
    }

    public void setValidtime(Date validtime) {
        this.validtime = validtime;
    }
}