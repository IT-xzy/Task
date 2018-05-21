package com.hedonglin.dao;

import com.hedonglin.model.Talent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TalentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Talent record);

    int insertSelective(Talent talent);

    Talent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Talent talent);

    int updateByPrimaryKeyWithBLOBs(Talent talent);

    int updateByPrimaryKey(Talent talent);

    List<Talent> randomSelectTalent();

    Long selectIdByName(String name);

    Talent selectByName(String name);
}