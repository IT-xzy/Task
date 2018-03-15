package com.hedonglin.model;

import java.util.Objects;

public class Talent {
    private Long id;

    private String name;

    private String job;

    private String photo;

    private String jobDescription;

    private String password;

    private String salt;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription == null ? null : jobDescription.trim();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Talent talent = (Talent) o;
        return Objects.equals(id, talent.id) &&
                Objects.equals(name, talent.name) &&
                Objects.equals(job, talent.job) &&
                Objects.equals(photo, talent.photo) &&
                Objects.equals(jobDescription, talent.jobDescription) &&
                Objects.equals(password, talent.password) &&
                Objects.equals(salt, talent.salt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, job, photo, jobDescription, password, salt);
    }

    @Override
    public String toString() {
        return "Talent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", photo='" + photo + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}