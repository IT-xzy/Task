package domain.dao;

import domain.entity.StuApply;

import java.util.List;

public interface StuApplyMapper {

    int insert(StuApply stuApply);

    List<StuApply> selectAll();

    int selectCount();

    StuApply getByUsername(String username);

    StuApply getByPhone(String telephone);

    int updateByUsername(StuApply stuApply);
}