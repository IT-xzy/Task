package com.jnshu.mapper;

import com.jnshu.model.Profession;

import java.util.List;

public interface ProfessionDao {
    Profession findByIdProfession(int id);
    List<Profession> findByListProfession();
    boolean deleteByIdProfession(int id);
    int insertByProfession(Profession profession);
    boolean updateByProfession(Profession profession);
}
