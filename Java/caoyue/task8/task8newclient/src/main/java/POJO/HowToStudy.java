package POJO;

import java.io.Serializable;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 描述学习过程
 * @create: 2018/5/7 下午5:38
 */

public class HowToStudy implements Serializable{
    private Integer ID;
    private String introduce;
    
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getIntroduce() {
        return introduce;
    }
    
    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
