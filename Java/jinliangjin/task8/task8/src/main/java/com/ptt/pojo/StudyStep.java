package com.ptt.pojo;

import java.io.Serializable;

/**
 * @ProjectName: task4
 * @Package: com.ptt.pojo
 * @ClassName: StudyStep
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/25 10:16
 * @UpdateUser:
 * @UpdateDate: 2018/5/25 10:16
 * @UpdateRemark:
 * @Version: 1.0
 */
public class StudyStep implements Serializable{
    private static final long serialVersionUID = 1115L;
    private Integer id;
    private String step;
    public StudyStep(){}

    public StudyStep(Integer id, String step) {
        this.id = id;
        this.step = step;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }
}
