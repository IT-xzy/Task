package com.mutesaid.mapper;

import com.mutesaid.model.Expert;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;


public interface ExpertMapper {

    List<Expert> findList();
}
