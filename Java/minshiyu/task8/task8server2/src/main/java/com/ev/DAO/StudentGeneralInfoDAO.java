package com.ev.DAO;

import com.ev.entity.StudentGeneralInfo;

import java.sql.SQLException;

public interface StudentGeneralInfoDAO {

    StudentGeneralInfo selectMainStatus() throws SQLException;

}
