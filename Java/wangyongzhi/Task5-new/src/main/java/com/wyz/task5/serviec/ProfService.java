package com.wyz.task5.serviec;


import com.wyz.task5.domain.entity.Prof;

public interface ProfService {

    //根据名称查询职业信息
    Prof getByProf(String profession);

}
