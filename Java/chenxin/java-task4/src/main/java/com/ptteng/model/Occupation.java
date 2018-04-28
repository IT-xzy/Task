package com.ptteng.model;

public class Occupation {
    private long id;
    private String occupation;
    private String info;
    private short threshold;
    private short difficulty_level;
    private String growth_cycle;
    private String rareness;
    private String experience1;
    private String salary1;
    private String experience2;
    private String salary2;
    private String experience3;
    private String salary3;
    private int students;
    private String reminder;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public short getThreshold() {
        return threshold;
    }

    public void setThreshold(short threshold) {
        this.threshold = threshold;
    }

    public short getDifficulty_level() {
        return difficulty_level;
    }

    public void setDifficulty_level(short difficulty_level) {
        this.difficulty_level = difficulty_level;
    }

    public String getGrowth_cycle() {
        return growth_cycle;
    }

    public void setGrowth_cycle(String growth_cycle) {
        this.growth_cycle = growth_cycle;
    }

    public String getRareness() {
        return rareness;
    }

    public void setRareness(String rareness) {
        this.rareness = rareness;
    }

    public String getExperience1() {
        return experience1;
    }

    public void setExperience1(String experience1) {
        this.experience1 = experience1;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }

    public String getExperience2() {
        return experience2;
    }

    public void setExperience2(String experience2) {
        this.experience2 = experience2;
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2;
    }

    public String getExperience3() {
        return experience3;
    }

    public void setExperience3(String experience3) {
        this.experience3 = experience3;
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", occupation='" + occupation + '\'' +
                ", info='" + info + '\'' +
                ", threshold=" + threshold +
                ", difficulty_level=" + difficulty_level +
                ", growth_cycle='" + growth_cycle + '\'' +
                ", rareness='" + rareness + '\'' +
                ", experience1='" + experience1 + '\'' +
                ", salary1='" + salary1 + '\'' +
                ", experience2='" + experience2 + '\'' +
                ", salary2='" + salary2 + '\'' +
                ", experience3='" + experience3 + '\'' +
                ", salary3='" + salary3 + '\'' +
                ", students='" + students + '\'' +
                ", reminder='" + reminder + '\'' +
                '}';
    }
}
