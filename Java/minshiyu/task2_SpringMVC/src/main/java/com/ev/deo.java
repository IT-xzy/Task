package com.ev;

import java.util.Date;

public class deo {
    private Integer id;
    private String name;
    private Date birth;

    @Override
    public String toString() {
        return "deo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                '}';
    }

}
