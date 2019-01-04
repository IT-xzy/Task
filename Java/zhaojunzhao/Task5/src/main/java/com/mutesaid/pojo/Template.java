package com.mutesaid.pojo;

import java.util.ArrayList;

public class Template {

    private Long id;
    private String name;

    /* 状态 0：   1：   */
    private int status;

    /* 四个一级指标 */
    private ArrayList<Element> elements;

    private Long createAt;
    private Long createBy;
    private Long updateAt;
    private Long updateBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Element> getElements() {
        return elements;
    }

    public void setElements(Element root1, Element root2, Element root3, Element root4) {
        this.elements = new ArrayList<>();
        elements.add(root1);
        elements.add(root2);
        elements.add(root3);
        elements.add(root4);
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }
}
