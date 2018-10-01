package spring.model;

public class Occupation {
    private Integer id; //编号
    private String name;  //职业
    private String duty;   //职责
    private Integer threshold; //门槛
    private Integer difficulty; //难度
    private String cycle; //成长周期
    private Integer rare;  //稀缺程度
    private String first;   //第一阶段薪资待遇
    private String second;   //第二阶段薪资待遇
    private String third;   //第三阶段薪资待遇
    private String prompt;   //提示
    private String introduce; //介绍

    @Override
    public String toString() {
        return "Occupation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duty='" + duty + '\'' +
                ", threshold=" + threshold +
                ", difficulty=" + difficulty +
                ", cycle='" + cycle + '\'' +
                ", rare=" + rare +
                ", first='" + first + '\'' +
                ", second='" + second + '\'' +
                ", third='" + third + '\'' +
                ", prompt='" + prompt + '\'' +
                ", introduce='" + introduce + '\'' +
                '}';
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
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

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Integer getRare() {
        return rare;
    }

    public void setRare(Integer rare) {
        this.rare = rare;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getThird() {
        return third;
    }

    public void setThird(String third) {
        this.third = third;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
}
