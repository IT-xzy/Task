package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Arike
 * Create_at 2017/12/18 16:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class StudentPut implements Serializable {
    private static final long serialVersionUID=1L;
    //该类用于与web页面交互
    private Long id;
    private String name;
    private String QQ;
    private String major;
    private String entry_time;
    private String gra_school;
    private String online_id;
    private String daily_link;
    private String desire;
    private String bro;
    private String know_from;
}
