package com.ev.DAO;

import com.ev.entity.GoodOne;

import java.sql.SQLException;
import java.util.List;

public interface GoodOneDAO {

    Long addGoodOne(GoodOne goodOne) throws SQLException;

    List<GoodOne> findAllGoodOnes() throws SQLException;

    GoodOne findById(Long id) throws Exception;
}
