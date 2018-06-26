package com.ev.dao;

import com.ev.entity.StudentGeneralInfo;

import java.sql.SQLException;

/*
拟每次先从学员列表student or goodone中更新数据，再使用更新后的数据
 */
public interface StudentGeneralInfoDAO {

    //查询目前主要的学员状态，即在学人数、工作人数。
    StudentGeneralInfo selectMainStatus() throws SQLException;

    /*...
     *查询各职业在学人数。（暂无工作人数）（数据暂无）
     */
}
