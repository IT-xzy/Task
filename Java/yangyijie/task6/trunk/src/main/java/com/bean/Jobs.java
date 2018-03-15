package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Arike
 * Create_at 2018/1/2 10:29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Jobs implements Serializable {
    private Long id;
    private Long createAt;
    private Long updateAt;
    private String jobname;
    private String lowSalary;
    private String mediumSalary;
    private String highSalary;
    private Integer online;
    private String head;
    private String intro;
    private Integer introsId;
    private String hint;
    private JobsIntros jobsIntros;
    
}
