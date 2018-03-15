package com.hedonglin.model;

import java.util.Objects;

public class Job {
    private Long id;

    private String job;

    private Integer entrance;

    private Integer degreeOfDifficulty;

    private String oneYear;

    private String twoToThreeYear;

    private String threeToFiveYear;

    private String learningNumber;

    private String rare;

    private String learnCycle;

    private String prompt;

    private String jobDescription;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getEntrance() {
        return entrance;
    }

    public void setEntrance(Integer entrance) {
        this.entrance = entrance;
    }

    public Integer getDegreeOfDifficulty() {
        return degreeOfDifficulty;
    }

    public void setDegreeOfDifficulty(Integer degreeOfDifficulty) {
        this.degreeOfDifficulty = degreeOfDifficulty;
    }

    public String getOneYear() {
        return oneYear;
    }

    public void setOneYear(String oneYear) {
        this.oneYear = oneYear;
    }

    public String getTwoToThreeYear() {
        return twoToThreeYear;
    }

    public void setTwoToThreeYear(String twoToThreeYear) {
        this.twoToThreeYear = twoToThreeYear;
    }

    public String getThreeToFiveYear() {
        return threeToFiveYear;
    }

    public void setThreeToFiveYear(String threeToFiveYear) {
        this.threeToFiveYear = threeToFiveYear;
    }

    public String getLearningNumber() {
        return learningNumber;
    }

    public void setLearningNumber(String learningNumber) {
        this.learningNumber = learningNumber;
    }

    public String getRare() {
        return rare;
    }

    public void setRare(String rare) {
        this.rare = rare;
    }

    public String getLearnCycle() {
        return learnCycle;
    }

    public void setLearnCycle(String learnCycle) {
        this.learnCycle = learnCycle;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", job='" + job + '\'' +
                ", entrance=" + entrance +
                ", degreeOfDifficulty=" + degreeOfDifficulty +
                ", oneYear='" + oneYear + '\'' +
                ", twoToThreeYear='" + twoToThreeYear + '\'' +
                ", threeToFiveYear='" + threeToFiveYear + '\'' +
                ", learningNumber='" + learningNumber + '\'' +
                ", rare='" + rare + '\'' +
                ", learnCycle='" + learnCycle + '\'' +
                ", prompt='" + prompt + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job1 = (Job) o;
        return Objects.equals(id, job1.id) &&
                Objects.equals(job, job1.job) &&
                Objects.equals(entrance, job1.entrance) &&
                Objects.equals(degreeOfDifficulty, job1.degreeOfDifficulty) &&
                Objects.equals(oneYear, job1.oneYear) &&
                Objects.equals(twoToThreeYear, job1.twoToThreeYear) &&
                Objects.equals(threeToFiveYear, job1.threeToFiveYear) &&
                Objects.equals(learningNumber, job1.learningNumber) &&
                Objects.equals(rare, job1.rare) &&
                Objects.equals(learnCycle, job1.learnCycle) &&
                Objects.equals(prompt, job1.prompt) &&
                Objects.equals(jobDescription, job1.jobDescription);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, job, entrance, degreeOfDifficulty, oneYear, twoToThreeYear, threeToFiveYear, learningNumber, rare, learnCycle, prompt, jobDescription);
    }
}


