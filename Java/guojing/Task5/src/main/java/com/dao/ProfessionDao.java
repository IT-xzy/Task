package com.dao;

import com.entity.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionDao {

    List<Profession> findProfession();
}
