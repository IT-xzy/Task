package com.tiles.service;

import com.tiles.model.Profession;

import java.util.List;

public interface ProfessionService {
    List<Profession> getAll();

    int addProfession(Profession profession);
}
