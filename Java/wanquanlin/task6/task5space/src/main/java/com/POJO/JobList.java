package com.POJO;

import java.io.Serializable;

/**
 * @Author: Jaime
 * @Date: 2018/4/4 1:10
 * @Description: *
 */
public class JobList implements Serializable{
    private int ID;
    private String jobname;
    private String description;
    private String growth_cycle;
    private String number_of_company;
    private String salary1;
    private String salary2;
    private String salary3;
    private  String hint;
    private String numoflearingstudent;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGrowth_cycle() {
        return growth_cycle;
    }

    public void setGrowth_cycle(String growth_cycle) {
        this.growth_cycle = growth_cycle;
    }

    public String getNumber_of_company() {
        return number_of_company;
    }

    public void setNumber_of_company(String number_of_company) {
        this.number_of_company = number_of_company;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2;
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getNumoflearingstudent() {
        return numoflearingstudent;
    }


    public void setNumoflearingstudent(String numoflearingstudent) {
        this.numoflearingstudent = numoflearingstudent;
    }
}
