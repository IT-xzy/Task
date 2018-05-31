package pojo;


import java.io.Serializable;

public class Job implements Serializable {
    private  int id;
    private  String name;
    private  String introduction;
    private  String sill;
    private  String difficulty;
    private  int need;
    private  String sallery;
    private  String type;
    private  String prompt;
    private  String image;
    private  int totals;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getSill() {
        return sill;
    }

    public void setSill(String sill) {
        this.sill = sill;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public int getNeed() {
        return need;
    }

    public void setNeed(int need) {
        this.need = need;
    }

    public String getSallery() {
        return sallery;
    }

    public void setSallery(String sallery) {
        this.sallery = sallery;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getTotals() {
        return totals;
    }

    public void setTotals(int totals) {
        this.totals = totals;
    }
}
