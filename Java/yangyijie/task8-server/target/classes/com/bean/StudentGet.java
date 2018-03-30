package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Arike
 * Create_at 2017/12/14 13:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class StudentGet implements Serializable {
    private static final long serialVersionUID=1L;
    //该类用于与web页面交互
    private String name;
    private String QQ;
    private String major;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date entry_time;
    private String gra_school;
    private String online_id;
    private String daily_link;
    private String desire;
    private String bro;
    private String know_from;
}
