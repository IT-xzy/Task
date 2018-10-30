package com.jnshu.MyBatis;

import com.jnshu.model.Profession;

import java.util.List;

public interface ProfessionDao {

    List<Profession> all();
    List<Profession> after();
    List<Profession> ops();

}
