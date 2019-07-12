package com.jnshu.mapper;

import com.jnshu.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {


    List<User> selectAll();


}
