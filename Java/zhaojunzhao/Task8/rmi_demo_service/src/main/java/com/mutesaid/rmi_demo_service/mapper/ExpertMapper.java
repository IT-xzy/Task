package com.mutesaid.rmi_demo_service.mapper;

import com.mutesaid.rmi_demo_core.model.Expert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ExpertMapper {

    List<Expert> findList();
}
