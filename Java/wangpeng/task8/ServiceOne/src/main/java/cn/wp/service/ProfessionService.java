package cn.wp.service;

import cn.wp.model.Profession;

import java.util.List;

/**
 * @ClassName: ProfessionService
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/18 12:15
 * @Version: 1.0
 */
public interface ProfessionService {
    int deleteByPrimaryKey(Long id);

    int insert(Profession record);

    int insertSelective(Profession record);

    Profession selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Profession record);

    int updateByPrimaryKey(Profession record);

    List<Profession> selectByDynamicCondition(Long count);

    List<Profession> selectAll();

}
