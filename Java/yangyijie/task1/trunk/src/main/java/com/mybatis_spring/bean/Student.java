package com.mybatis_spring.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author Arike
 * Create_at 2017/12/1 14:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Long id ;
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
    //提供除了ID以外的构造方法.
    
    public Student(Long create_at, Long update_at, String name, String QQ, String major, Long entry_time, String gra_school, String online_id, String daily_link, String desire, String bro, String know_from) {
        this.create_at = create_at;
        this.update_at = update_at;
        this.name = name;
        this.QQ = QQ;
        this.major = major;
        this.entry_time = entry_time;
        this.gra_school = gra_school;
        this.online_id = online_id;
        this.daily_link = daily_link;
        this.desire = desire;
        this.bro = bro;
        this.know_from = know_from;
    }
    
    
    //提供除了ID和创建时间的构造方法.
    
    
    public Student(Long update_at, String name, String QQ, String major, Long entry_time, String gra_school, String online_id, String daily_link, String desire, String bro, String know_from) {
        this.update_at = update_at;
        this.name = name;
        this.QQ = QQ;
        this.major = major;
        this.entry_time = entry_time;
        this.gra_school = gra_school;
        this.online_id = online_id;
        this.daily_link = daily_link;
        this.desire = desire;
        this.bro = bro;
        this.know_from = know_from;
    }
}
