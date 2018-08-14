package com.fgh.task2.model;

import com.fgh.task2.tool.TimeReversal;

public class Stu {
    private Integer id;
    private String f_stuName;
    private String f_picture;
    private Integer f_profession_id;
    private String f_stuIntroduce;
    private Boolean f_isOutstanding;
    private Boolean f_working;
    private Long create_at;
    private Long update_at;
    private String create_by;
    private String update_by;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getF_stuName() {
        return f_stuName;
    }

    public void setF_stuName(String f_stuName) {
        this.f_stuName = f_stuName;
    }

    public String getF_picture() {
        return f_picture;
    }

    public void setF_picture(String f_picture) {
        this.f_picture = f_picture;
    }

    public Integer getF_profession_id() {
        return f_profession_id;
    }

    public void setF_profession_id(Integer f_profession_id) {
        this.f_profession_id = f_profession_id;
    }

    public String getF_stuIntroduce() {
        return f_stuIntroduce;
    }

    public void setF_stuIntroduce(String f_stuIntroduce) {
        this.f_stuIntroduce = f_stuIntroduce;
    }

    public Boolean getF_isOutstanding() {
        return f_isOutstanding;
    }

    public void setF_isOutstanding(Boolean f_isOutstanding) {
        this.f_isOutstanding = f_isOutstanding;
    }


    public Boolean getF_working() {
        return f_working;
    }

    public void setF_working(Boolean f_working) {
        this.f_working = f_working;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }
}
