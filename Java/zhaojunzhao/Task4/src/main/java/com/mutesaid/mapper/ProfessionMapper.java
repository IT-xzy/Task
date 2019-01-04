package com.mutesaid.mapper;

import com.mutesaid.pojo.Profession;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProfessionMapper {
    List<Profession> getProfessList(String direction);
}