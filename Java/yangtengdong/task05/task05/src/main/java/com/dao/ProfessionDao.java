package com.dao;

import com.entity.Profession;

import java.util.List;

public interface ProfessionDao {
    Profession findById(Integer id);
    List<Profession> listAll();
    void insert(Profession profession);
    List<Profession> findByStyle (String style);

}
