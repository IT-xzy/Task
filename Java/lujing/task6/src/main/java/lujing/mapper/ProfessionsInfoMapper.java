package lujing.mapper;

import lujing.pojo.ProfessionsInfo;

public interface ProfessionsInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfessionsInfo record);

    int insertSelective(ProfessionsInfo record);

    ProfessionsInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProfessionsInfo record);

    int updateByPrimaryKey(ProfessionsInfo record);
}