package com.ptteng.dao;

import com.ptteng.entity.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessionDao {

    List<Profession> findProfession();
}
