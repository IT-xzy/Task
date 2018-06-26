package com.alibaba.model;

import java.math.BigDecimal;

public class Position {
    private Integer id;
    private String occupation;
    private String duty;
    private  String threshold;
    private String difficultyDegree;
    private  String growthCycle;
    private String degreeOfScarcity;
    private String marketDemand;
    private BigDecimal theMinimumSalary1;
    private String theMinimumSalary2;
    private String theMinimumSalary3;
    private String maximumSalary1;
    private String maximumSalary2;
    private String maximumSalary3;
    private String experienceRequirement;
    private String inTheNumberOfStudents;
    private String promptStatement;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold;
    }

    public String getDifficultyDegree() {
        return difficultyDegree;
    }

    public void setDifficultyDegree(String difficultyDegree) {
        this.difficultyDegree = difficultyDegree;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle;
    }

    public String getDegreeOfScarcity() {
        return degreeOfScarcity;
    }

    public void setDegreeOfScarcity(String degreeOfScarcity) {
        this.degreeOfScarcity = degreeOfScarcity;
    }

    public String getMarketDemand() {
        return marketDemand;
    }

    public void setMarketDemand(String marketDemand) {
        this.marketDemand = marketDemand;
    }

    public BigDecimal getTheMinimumSalary1() {
        return theMinimumSalary1;
    }

    public void setTheMinimumSalary1(BigDecimal theMinimumSalary1) {
        this.theMinimumSalary1 = theMinimumSalary1;
    }

    public String getTheMinimumSalary2() {
        return theMinimumSalary2;
    }

    public void setTheMinimumSalary2(String theMinimumSalary2) {
        this.theMinimumSalary2 = theMinimumSalary2;
    }

    public String getTheMinimumSalary3() {
        return theMinimumSalary3;
    }

    public void setTheMinimumSalary3(String theMinimumSalary3) {
        this.theMinimumSalary3 = theMinimumSalary3;
    }

    public String getMaximumSalary1() {
        return maximumSalary1;
    }

    public void setMaximumSalary1(String maximumSalary1) {
        this.maximumSalary1 = maximumSalary1;
    }

    public String getMaximumSalary2() {
        return maximumSalary2;
    }

    public void setMaximumSalary2(String maximumSalary2) {
        this.maximumSalary2 = maximumSalary2;
    }

    public String getMaximumSalary3() {
        return maximumSalary3;
    }

    public void setMaximumSalary3(String maximumSalary3) {
        this.maximumSalary3 = maximumSalary3;
    }

    public String getExperienceRequirement() {
        return experienceRequirement;
    }

    public void setExperienceRequirement(String experienceRequirement) {
        this.experienceRequirement = experienceRequirement;
    }

    public String getInTheNumberOfStudents() {
        return inTheNumberOfStudents;
    }

    public void setInTheNumberOfStudents(String inTheNumberOfStudents) {
        this.inTheNumberOfStudents = inTheNumberOfStudents;
    }

    public String getPromptStatement() {
        return promptStatement;
    }

    public void setPromptStatement(String promptStatement) {
        this.promptStatement = promptStatement;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", occupation='" + occupation + '\'' +
                ", duty='" + duty + '\'' +
                ", threshold='" + threshold + '\'' +
                ", difficultyDegree='" + difficultyDegree + '\'' +
                ", growthCycle='" + growthCycle + '\'' +
                ", degreeOfScarcit='" + degreeOfScarcity + '\'' +
                ", marketDemand='" + marketDemand + '\'' +
                ", theMinimumSalary1=" + theMinimumSalary1 +
                ", theMinimumSalary2='" + theMinimumSalary2 + '\'' +
                ", theMinimumSalary3='" + theMinimumSalary3 + '\'' +
                ", maximumSalary1='" + maximumSalary1 + '\'' +
                ", maximumSalary2='" + maximumSalary2 + '\'' +
                ", maximumSalary3='" + maximumSalary3 + '\'' +
                ", experienceRequirement='" + experienceRequirement + '\'' +
                ", inTheNumberOfStudents='" + inTheNumberOfStudents + '\'' +
                ", promptStatement='" + promptStatement + '\'' +
                '}';
    }
}
