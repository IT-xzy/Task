package mapper;

import model.Prof;

public interface ProfMapper {

    //根据名称查询职业信息
    public Prof getByProf(String profession);
}
