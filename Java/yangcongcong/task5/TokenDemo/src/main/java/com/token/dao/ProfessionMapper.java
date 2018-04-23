package com.token.dao;

import com.token.model.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper {
    List<Profession> getAll();

    int addProfession(Profession profession);
}
