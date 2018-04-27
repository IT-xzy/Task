package com.tiles.dao;

import com.tiles.model.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper {
    List<Profession> getAll();

    int addProfession(Profession profession);
}
