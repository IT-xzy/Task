package com.mutesaid.rmi_demo_service.mapper;

import com.mutesaid.rmi_demo_core.model.Profession;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProfessionMapper {
    List<Profession> findProfessionList(String direction);

    List<String> findDirectionList();
}
