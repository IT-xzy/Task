package com.mutesaid.mapper;

import com.mutesaid.model.Profession;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;


public interface ProfessionMapper {
    List<Profession> findProfessionList(String direction);

    List<String> findDirectionList();
}
