package com.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @author Arike
 * Create_at 2017/12/14 10:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Student {
    //该类用于与数据库交互
    
    private Long id;
    private Long create_at;
    private Long update_at;
    private String name;
    private String QQ;
    private String major;
    private Long entry_time;
    private String gra_school;
    private String online_id;
    private String daily_link;
    private String desire;
    private String bro;
    private String know_from;
}
    
    



