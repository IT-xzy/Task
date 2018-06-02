package com.ptt.Enum;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: task4
 * @Package: com.ptt.Enum
 * @ClassName: StudyStep
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/24 17:47
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 17:47
 * @UpdateRemark:
 * @Version: 1.0
 */
public enum  StudySteps {

    @Value("#{configProperties['ONE']}") ONE("ONE"), @Value("#{configProperties['TWO']}") TWO("TWO"),
    @Value("#{configProperties['THREE']}") THREE("THREE"), @Value("#{configProperties['FOUR']}") FOUR("FOUR"),
    @Value("#{configProperties['ONE']}") FIVE("FIVE"), @Value("#{configProperties['ONE']}") SIX("SIX"),
    @Value("#{configProperties['ONE']}") SEVEN("SEVEN"), @Value("#{configProperties['ONE']}") EIGHT("EIGHT");

    private String description;

    private StudySteps(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
