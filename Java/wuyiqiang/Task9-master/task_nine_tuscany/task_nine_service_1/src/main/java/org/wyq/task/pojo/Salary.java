package org.wyq.task.pojo;

import java.io.Serializable;

public class Salary implements Serializable {
    private Integer id;

    private String timeOne;

    private String salaryOne;

    private String timeTwo;

    private String salaryTwo;

    private String timeThree;

    private String salaryThree;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTimeOne() {
        return timeOne;
    }

    public void setTimeOne(String timeOne) {
        this.timeOne = timeOne == null ? null : timeOne.trim();
    }

    public String getSalaryOne() {
        return salaryOne;
    }

    public void setSalaryOne(String salaryOne) {
        this.salaryOne = salaryOne == null ? null : salaryOne.trim();
    }

    public String getTimeTwo() {
        return timeTwo;
    }

    public void setTimeTwo(String timeTwo) {
        this.timeTwo = timeTwo == null ? null : timeTwo.trim();
    }

    public String getSalaryTwo() {
        return salaryTwo;
    }

    public void setSalaryTwo(String salaryTwo) {
        this.salaryTwo = salaryTwo == null ? null : salaryTwo.trim();
    }

    public String getTimeThree() {
        return timeThree;
    }

    public void setTimeThree(String timeThree) {
        this.timeThree = timeThree == null ? null : timeThree.trim();
    }

    public String getSalaryThree() {
        return salaryThree;
    }

    public void setSalaryThree(String salaryThree) {
        this.salaryThree = salaryThree == null ? null : salaryThree.trim();
    }
}