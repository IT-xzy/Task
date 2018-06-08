package com.tiles.service.impl;

import com.tiles.dao.HomeMapper;
import com.tiles.model.Home;
import com.tiles.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    private HomeMapper homeMapper;

    @Override
    public int addHome(Home home) {
        return homeMapper.addHome(home);
    }

    @Override
    public int deleteHome(long id) {
        return homeMapper.deleteHome(id);
    }

    @Override
    public int updateHome(Home home) {
        return homeMapper.updateHome(home);
    }

    @Override
    public Home getById(long id) {
        return homeMapper.getById(id);
    }

    @Override
    public List<Home> getAll() {
        return homeMapper.getAll();
    }
}
