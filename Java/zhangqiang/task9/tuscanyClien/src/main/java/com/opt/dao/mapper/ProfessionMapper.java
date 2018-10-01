package com.opt.dao.mapper;

import com.opt.model.Profession;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Mapper
@Component
public interface ProfessionMapper {

    int findAllCount();

    List<Profession> findByPage(HashMap<String, Object> map);

    List<Profession> findAll();


}


