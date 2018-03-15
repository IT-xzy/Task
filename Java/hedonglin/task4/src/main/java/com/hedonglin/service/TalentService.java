package com.hedonglin.service;

import com.hedonglin.model.Talent;

import java.util.List;

public interface TalentService {

    int deleteByPrimaryKey(Long id);

    int insert(Talent talent);

    int insertSelective(Talent talent);

    Talent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Talent talent);

    int updateByPrimaryKeyWithBLOBs(Talent talent);

    int updateByPrimaryKey(Talent talent);

    List<Talent> randomSelectTalent();
}
