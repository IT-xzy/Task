package com.mutesaid.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Element {
    private Long id;

    private String name;

    /* 期望分数 */
    private Integer grade;

    /* 实际分数 */
    private Integer actualGrade;

    /* 期望完成度 */
    private String expect;

    /* 实际完成度 */
    private String actual;

    /* 解释 */
    private String explain;

    /* 评分标准 */
    private String standard;

    /* 父元素id */
    private Long parentId;

    /* 子元素列表 */
    private ArrayList<Element> chrildren;

    public Element(Long id, String name, Integer grade, String expect, String explain, String standard, Long parentId) {
        this.id = id;
        this.name = name;
        this.grade = grade;
//        this.actualGrade = actualGrade;
        this.expect = expect;
//        this.actual = actual;
        this.explain = explain;
        this.standard = standard;
        this.parentId = parentId;
        this.chrildren = null;
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

    public Integer getActualGrade() {
        return actualGrade;
    }

    public void setActualGrade(Integer actualGrade) {
        this.actualGrade = actualGrade;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
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

    public ArrayList<Element> getChrildren() {
        return chrildren;
    }

    public void setChrildren(ArrayList<Element> chrildren) {
        this.chrildren = chrildren;
    }
}
