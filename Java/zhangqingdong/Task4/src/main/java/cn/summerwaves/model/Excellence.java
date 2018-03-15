package cn.summerwaves.model;

public class Excellence {

    private String name;
    private String position;
    private String introduction;
    private String photograph;

    @Override
    public String toString() {
        return "Excellence{" +
                "name='" + name + '\'' +
                ", Position='" + position + '\'' +
                ", introduction='" + introduction + '\'' +
                ", photograph='" + photograph + '\'' +
                '}';
    }

    public Excellence(String name, String position, String introduction, String photograph) {
        this.name = name;
        this.position = position;
        this.introduction = introduction;
        this.photograph = photograph;
    }

    public Excellence() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhotograph() {
        return photograph;
    }

    public void setPhotograph(String photograph) {
        this.photograph = photograph;
    }


}
