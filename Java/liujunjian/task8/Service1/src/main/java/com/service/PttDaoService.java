package com.service;

import com.exception.MyException;
import com.pojo.Profession;

import java.util.List;

public interface PttDaoService {
    int getStudentSum() throws MyException;

    int getGraduateSum() throws MyException;

    List<Profession> getAllProfession() throws MyException;

    List<String> getImageAddress();
}
