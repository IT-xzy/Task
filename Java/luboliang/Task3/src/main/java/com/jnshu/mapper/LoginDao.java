package com.jnshu.mapper;

import com.jnshu.model.Login;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LoginDao {
    public long addLogin(Login login);

    public boolean deleteLogin(long id);

    public boolean updateLogin(Login login);

    public Login findByLogin(long id);

    public List<Login> findAllLogin();
}
