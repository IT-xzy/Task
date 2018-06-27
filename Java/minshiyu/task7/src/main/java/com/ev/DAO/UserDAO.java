package com.ev.DAO;

import com.ev.entity.User;

import java.sql.SQLException;

public interface UserDAO {

    User findByName(String name) throws SQLException;

    User findByEmail(String email) throws SQLException;

    User findByPhoneNumber(String phoneNumber) throws SQLException;

    User findById(Long id) throws SQLException;

    Long addUser(User user) throws SQLException;

    void setStatus(User user) throws SQLException;

}
