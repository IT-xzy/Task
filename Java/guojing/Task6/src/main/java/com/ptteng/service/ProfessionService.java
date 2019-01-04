package com.ptteng.service;

import com.ptteng.entity.Profession;

import java.util.List;

public interface ProfessionService {

    List<Profession> findProfession(Integer page, Integer size);

    Boolean updatePro(Profession profession);

    Long insertPro(Profession profession);

    Boolean deletePro(Long id);

    Profession findOnePro(Long id);

    List<Profession> findAll(Integer page, Integer size);
}
