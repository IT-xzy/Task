package com.opt.dao.mapper;

import com.opt.model.OptUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface OptUserMapper {


    OptUser findById(int id);

    OptUser findByName(String name);

    OptUser findByPhone(long phone);

    OptUser findByEmail(String email);

    int findCountTotal();

    List<OptUser> findByUser(OptUser optUser);

    int insert(OptUser optUser);

    int update(OptUser optUser);

}
