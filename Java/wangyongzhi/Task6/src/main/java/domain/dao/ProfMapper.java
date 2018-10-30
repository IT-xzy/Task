package domain.dao;


import domain.entity.Prof;

public interface ProfMapper {

    //根据名称查询职业信息
    public Prof getByProf(String profession);
}
