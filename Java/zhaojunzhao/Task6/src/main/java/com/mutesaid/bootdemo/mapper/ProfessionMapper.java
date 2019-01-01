package com.mutesaid.bootdemo.mapper;

import com.mutesaid.bootdemo.model.Profession;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessionMapper {
    List<Profession> findProfessionList(String direction);

    List<String> findDirectionList();
}
