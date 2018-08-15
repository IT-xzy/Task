package com.pojo;

public class OccupationReunite extends Occupation{
    private int studentNumber;

    @Override
    public String toString() {
        return "OccupationReunite{" + "studentNumber=" + studentNumber + '}';
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }
}
