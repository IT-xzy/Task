package com.service;

import com.entity.Profession;

import java.util.List;

public interface ProfessionService {
    Profession findById(Integer id);
    List<Profession> listAll();
    void insert(Profession profession);
    List<Profession> findByStyle (String style);
}
