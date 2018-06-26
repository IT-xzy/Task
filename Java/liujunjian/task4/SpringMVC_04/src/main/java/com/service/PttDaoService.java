package com.service;

import com.pojo.Profession;

import java.util.List;

public interface PttDaoService {
    Profession findProfession(String profession) throws Exception;

    List<Profession> findAll() throws Exception;
}
