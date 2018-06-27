package com.tiles.dao;

import com.tiles.model.Home;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeMapper {
    int addHome(Home home);

    int  deleteHome(long id);

    int updateHome(Home home);

    Home getById(long id);

    List<Home> getAll();
}
