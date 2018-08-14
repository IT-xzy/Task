package com.jnshu.service;

import com.jnshu.entity.Profession;

import java.util.List;

public interface ProfessionService {

    List<Profession> findAlls();

    int findName();

    Profession addlist(Profession profession);
}
