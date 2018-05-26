package com.fangyuyang.service;

import com.fangyuyang.model.Career;

import java.util.List;

public interface CareerService {
    void addCareer(Career career);

    void updateCareer(Career career);

    void deleteCareer(int id);

    Career findCareerById(int id);

    List<Career> findAll();
    int[] findCareer();

}
