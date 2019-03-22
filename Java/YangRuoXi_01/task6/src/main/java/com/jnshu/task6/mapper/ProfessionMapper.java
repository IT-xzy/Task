package com.jnshu.task6.mapper;

import com.jnshu.task6.beans.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionMapper {
    List<Profession> selectAllProfession();

    List<Profession> selectProfessionByName();
}
