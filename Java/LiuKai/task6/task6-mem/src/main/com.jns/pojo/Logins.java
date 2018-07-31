package pojo;

import java.util.Date;

public class Logins {
    long id;
    String username;
    String token;
    String series;
    long logntime;

    @Override
    public String toString() {
        return "login id="+id+
                "time="+logntime;
    }

    public long getId() {
        return id;
    }

    public Logins setId(long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Logins setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getToken() {
        return token;
    }

    public Logins setToken(String token) {
        this.token = token;
        return this;
    }

    public String getSeries() {
        return series;
    }

    public Logins setSeries(String series) {
        this.series = series;
        return this;
    }

    public long getLogntime() {
        return logntime;
    }

    public Logins setLogntime(long logntime) {
        this.logntime = logntime;
        return this;
    }
}
