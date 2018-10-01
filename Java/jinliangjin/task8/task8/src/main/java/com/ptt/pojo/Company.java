package com.ptt.pojo;

import java.io.Serializable;

/**
 * @ProjectName: task4
 * @Package: com.ptt.pojo
 * @ClassName: Company
 * @Description: 公司
 * @Author: Jin
 * @CreateDate: 2018/5/24 19:01
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 19:01
 * @UpdateRemark:
 * @Version: 1.0
 */
public class Company implements Serializable{
    private static final long serialVersionUID = 1111L;
    private Integer id;
    private String name;

    public Company(){}

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return "序号：" + id + "，公司名称：" + name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
