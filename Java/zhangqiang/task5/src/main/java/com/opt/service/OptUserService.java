package com.opt.service;

import com.opt.model.OptUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptUserService {

    OptUser findById(int id);

    OptUser findByName(String name);

    OptUser findByPhone(long phone);

    OptUser findByEmail(String email);

    int findCountTotal();

    List<OptUser> findByUser(OptUser optUser);

    int insert(OptUser optUser);

    int update(OptUser optUser);


}
