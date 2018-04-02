package lujing.pojo;

import java.io.Serializable;

public class Learn implements Serializable {
    private Integer id;

    private String message;

    private String picturePath;

    public Learn(Integer id, String message, String picturePath) {
        this.id = id;
        this.message = message;
        this.picturePath = picturePath;
    }

    public Learn() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath == null ? null : picturePath.trim();
    }
    
    @Override
    public String toString() {
        return "Learn{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", picturePath='" + picturePath + '\'' +
                '}';
    }
}