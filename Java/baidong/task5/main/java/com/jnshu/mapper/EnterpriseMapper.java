package com.jnshu.mapper;

import com.jnshu.model.Enterprise;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EnterpriseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Enterprise record);

    int insertSelective(Enterprise record);

    Enterprise selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Enterprise record);

    int updateByPrimaryKey(Enterprise record);

    List<Enterprise> selectAll();
}