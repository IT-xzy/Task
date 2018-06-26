package com.ev.dao;

import com.ev.entity.Occupation;

import java.util.List;

public interface OccupationDAO {

    //查询职业相关信息，如：java、css等。
    List<Occupation> selectOccupation() throws Exception;

}
