package com.ptteng.dao;

import com.ptteng.model.Occupation;

import java.util.List;

public interface OccupationDao {
    List<Occupation> getAll() throws Exception;
//    List<Occupation> getByOccupation(String occupation) throws Exception;
}

