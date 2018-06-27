package com.ev.DAO;

import com.ev.entity.Occupation;

import java.sql.SQLException;
import java.util.List;

public interface OccupationDAO {

    Long addOccupation(Occupation occupation) throws SQLException;

    List<Occupation> findAllOccupation() throws SQLException;

}
