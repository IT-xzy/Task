package com.mutesaid.bootdemo.mapper;

import com.mutesaid.bootdemo.model.Expert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpertMapper {

    List<Expert> findList();
}
