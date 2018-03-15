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
public class Jobs implements Serializable{
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jobs)) return false;
        if (!super.equals(o)) return false;
        
        Jobs jobs = (Jobs) o;
        
        if (id != null ? !id.equals(jobs.id) : jobs.id != null) return false;
        if (createAt != null ? !createAt.equals(jobs.createAt) : jobs.createAt != null) return false;
        if (updateAt != null ? !updateAt.equals(jobs.updateAt) : jobs.updateAt != null) return false;
        if (jobname != null ? !jobname.equals(jobs.jobname) : jobs.jobname != null) return false;
        if (lowSalary != null ? !lowSalary.equals(jobs.lowSalary) : jobs.lowSalary != null) return false;
        if (mediumSalary != null ? !mediumSalary.equals(jobs.mediumSalary) : jobs.mediumSalary != null) return false;
        if (highSalary != null ? !highSalary.equals(jobs.highSalary) : jobs.highSalary != null) return false;
        if (online != null ? !online.equals(jobs.online) : jobs.online != null) return false;
        if (head != null ? !head.equals(jobs.head) : jobs.head != null) return false;
        if (intro != null ? !intro.equals(jobs.intro) : jobs.intro != null) return false;
        if (introsId != null ? !introsId.equals(jobs.introsId) : jobs.introsId != null) return false;
        if (hint != null ? !hint.equals(jobs.hint) : jobs.hint != null) return false;
        return jobsIntros != null ? jobsIntros.equals(jobs.jobsIntros) : jobs.jobsIntros == null;
    }
}
