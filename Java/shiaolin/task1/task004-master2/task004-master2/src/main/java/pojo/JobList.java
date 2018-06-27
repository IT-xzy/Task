package pojo;

import java.util.List;
import java.io.*;



public class JobList implements Serializable {
    private List<Job> jobList;
    private static final long serialVersionUID = 123L;

    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }
    @Override
    public String toString() {
        return "JobList{" +
                ", jobList=" + jobList +
                '}';
    }
}
