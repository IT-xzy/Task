package com.jnshu.service;

import com.jnshu.model.Profession;

import java.util.List;

public interface ProfessionService {
    List<Profession> all();
    List<Profession> after();
    List<Profession> ops();

}
