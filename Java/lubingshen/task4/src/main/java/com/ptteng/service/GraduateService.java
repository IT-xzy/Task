package com.ptteng.service;

import com.ptteng.bean.Graduate;

import java.util.List;

public interface GraduateService {

    public int countGraduate();

    public Graduate findByPrimeKey(Long primekey) throws Exception;

    public List<Graduate> selectManyGraduates(int size)throws Exception;

}
