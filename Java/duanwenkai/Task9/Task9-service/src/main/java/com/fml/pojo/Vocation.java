package com.fml.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 职业信息是直接用数据库写死的。
 */
public class Vocation implements Serializable{
    private static final long serialVersionUID = 2310865184198265475L;
    /**职位ID*/
    private int voca_id;
    /**职位类型*/
    private String voca_type;
    /**职位名称*/
    private String voca_name;
    /**创建时间*/
    private Date create_at;
    /**更新时间*/
    private Date update_at;
    /**市场需求*/
    private int demand;
    /**职位门槛*/
    private int threshold;
    /**职位描述*/
    private String description;

    public int getVoca_id() {
        return voca_id;
    }

    public void setVoca_id(int voca_id) {
        this.voca_id = voca_id;
    }

    public String getVoca_type() {
        return voca_type;
    }

    public void setVoca_type(String voca_type) {
        this.voca_type = voca_type;
    }

    public String getVoca_name() {
        return voca_name;
    }

    public void setVoca_name(String voca_name) {
        this.voca_name = voca_name;
    }

    public Date getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Date create_at) {
        this.create_at = create_at;
    }

    public Date getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Date update_at) {
        this.update_at = update_at;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
