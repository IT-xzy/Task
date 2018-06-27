package com.token.service;


import com.token.model.Profession;

import java.util.List;

public interface ProfessionService {
    List<Profession> getAll();

    int addProfession(Profession profession);
}
