package com.jnshu.services;
import com.jnshu.model.Students;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

@Remotable
public interface StudentsServices {
    int deleteById(Long id);
    int insert(Students record);
    int insertSelective(Students record);
    Students selectById(Long id);
    int updateByIdSelective(Students record);
    int updateById(Students record);
    List<Students> selectAll();
    int updateByName(Students students);
}
