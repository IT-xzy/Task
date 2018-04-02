package lujing.mapper;

import lujing.pojo.Professions;

public interface ProfessionsMapper {
    
    int deleteByPrimaryKey(Integer id);

    int insert(Professions record);

    int insertSelective(Professions record);

    Professions selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Professions record);

    int updateByPrimaryKey(Professions record);
    
    
}