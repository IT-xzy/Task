package com.opt.service.impl;

import com.opt.dao.mapper.OptUserMapper;
import com.opt.model.OptUser;
import com.opt.service.OptUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class OptUserServiceImpl implements OptUserService {

    @Autowired
    private OptUserMapper optUserMapper;

    @Override
    public OptUser findById(int id) {
        return optUserMapper.findById(id);
    }

    @Override
    public OptUser findByName(String name) {
        return optUserMapper.findByName(name);
    }

    @Override
    public OptUser findByPhone(long phone) {
        return optUserMapper.findByPhone(phone);
    }

    @Override
    public OptUser findByEmail(String email) {
        return optUserMapper.findByEmail(email);
    }

    @Override
    public int findCountTotal() {
        return optUserMapper.findCountTotal();
    }

    @Override
    public List<OptUser> findByUser(OptUser optUser) {
        return optUserMapper.findByUser(optUser);
    }

    @Override
    public int insert(OptUser optUser) {
        return optUserMapper.insert(optUser);
    }

    @Override
    public int update(OptUser optUser) {
        return optUserMapper.update(optUser);
    }
}
