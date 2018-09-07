package com.jnshu.model;

public class JobInfo {
    private Integer id;

    private String image;

    private String jobName;

    private String jobDescripe;

    private Integer threshold;

    private Integer difficulty;

    private String growthCycle;

    private Integer degreeOfScarcity;

    private String treatmentOne;

    private String treatmentTwo;

    private String treatmentThree;

    private Integer learningNum;

    private String prompt;

    private Long creatTime;

    private Long modificationTime;

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getWorkDescripe() {
        return workDescripe;
    }

    public void setWorkDescripe(String workDescripe) {
        this.workDescripe = workDescripe;
    }

    private String work;

    private String workDescripe;
    public JobInfo(Integer id, String image, String jobName, String jobDescripe, Integer threshold, Integer difficulty, String growthCycle, Integer degreeOfScarcity, String treatmentOne, String treatmentTwo, String treatmentThree, Integer learningNum, String prompt,String work,String workDescripe, Long creatTime, Long modificationTime) {
        this.id = id;
        this.image = image;
        this.jobName = jobName;
        this.jobDescripe = jobDescripe;
        this.threshold = threshold;
        this.difficulty = difficulty;
        this.growthCycle = growthCycle;
        this.degreeOfScarcity = degreeOfScarcity;
        this.treatmentOne = treatmentOne;
        this.treatmentTwo = treatmentTwo;
        this.treatmentThree = treatmentThree;
        this.learningNum = learningNum;
        this.prompt = prompt;
        this.work = work;
        this.workDescripe = workDescripe;
        this.creatTime = creatTime;
        this.modificationTime = modificationTime;
    }

    public JobInfo() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobDescripe() {
        return jobDescripe;
    }

    public void setJobDescripe(String jobDescripe) {
        this.jobDescripe = jobDescripe == null ? null : jobDescripe.trim();
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getGrowthCycle() {
        return growthCycle;
    }

    public void setGrowthCycle(String growthCycle) {
        this.growthCycle = growthCycle == null ? null : growthCycle.trim();
    }

    public Integer getDegreeOfScarcity() {
        return degreeOfScarcity;
    }

    public void setDegreeOfScarcity(Integer degreeOfScarcity) {
        this.degreeOfScarcity = degreeOfScarcity;
    }

    public String getTreatmentOne() {
        return treatmentOne;
    }

    public void setTreatmentOne(String treatmentOne) {
        this.treatmentOne = treatmentOne == null ? null : treatmentOne.trim();
    }

    public String getTreatmentTwo() {
        return treatmentTwo;
    }

    public void setTreatmentTwo(String treatmentTwo) {
        this.treatmentTwo = treatmentTwo == null ? null : treatmentTwo.trim();
    }

    public String getTreatmentThree() {
        return treatmentThree;
    }

    public void setTreatmentThree(String treatmentThree) {
        this.treatmentThree = treatmentThree == null ? null : treatmentThree.trim();
    }

    public Integer getLearningNum() {
        return learningNum;
    }

    public void setLearningNum(Integer learningNum) {
        this.learningNum = learningNum;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt == null ? null : prompt.trim();
    }

    public Long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Long creatTime) {
        this.creatTime = creatTime;
    }

    public Long getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Long modificationTime) {
        this.modificationTime = modificationTime;
    }
}