package com.jnshu.task4.mapper;

import com.jnshu.task4.beans.Profession;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Qualifier
public interface ProfessionMapper {
    List<Profession> selectAllProfession();
}
