package com.ev.dao;

import com.ev.entity.GoodOne;

import java.sql.SQLException;
import java.util.List;

public interface GoodOnesDAO {

    //新增优秀学员
//    boolean addGoodOne(GoodOne goodOne) throws Exception;

    //查找所有优秀学员（理论上根据页面需求，取前几个，或hash存储随机取几个
    List<GoodOne> findGoodOnes() throws SQLException;

}
