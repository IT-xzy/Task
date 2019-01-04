package com.mutesaid.pojo;

public class ElementMap {
    private Long id;

    private String name;

    /* 期望分数 */
    private Integer grade;

    /* 期望完成度 */
    private String expect;

    /* 解释 */
    private String explain;

    /* 评分标准 */
    private String standard;

    /* 父元素id */
    private Long parentId;

    private Element[] elements;

    public ElementMap(Element[] elements) {
        this.elements = elements;
    }

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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElements(Element[] elements) {
        this.elements = elements;
    }
}
