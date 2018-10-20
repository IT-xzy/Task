package com.jnshu.Spring.jdbcTemplate;

public class DAOFactory {
    public static UserDao getDAOImpl() {
        return new UserDaoImpl();
    }
}
