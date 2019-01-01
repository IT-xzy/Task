package com.mutesaid.mapper;

import com.mutesaid.pojo.Profession;

import java.util.List;

public interface ProfessionMapper {
    List<Profession> getProfessList(String direction);

    List<String> getDirection();
}