package service;

import model.Prof;

public interface ProfService {

    //根据名称查询职业信息
    public Prof getByProf(String profession);

}
