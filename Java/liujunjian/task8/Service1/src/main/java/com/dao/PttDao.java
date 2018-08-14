package com.dao;

import com.exception.MyException;
import com.pojo.Profession;

import java.util.List;

public interface PttDao {
    List<Profession> findProfessions() throws MyException;
}
