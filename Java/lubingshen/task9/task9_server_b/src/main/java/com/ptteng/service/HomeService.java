package com.ptteng.service;

import com.ptteng.pojo.model.Graduate;

public interface HomeService {

    //毕业生计数（使用缓存）
    Object countGraduatesByCache();

    //学生计数（使用缓存）
    Object countStudentsByCache();

    //通过主键寻找毕业生
    Graduate findByPrimeKey(Long primekey) throws Exception;

    //随机抽取几个毕业生（不够则补足，使用缓存）
    Object getGraduatesByCache(int size) throws Exception;

}
