package com.ptteng.dao;

import com.ptteng.entity.Workroom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface WorkroomDao {

    List<Workroom> findWorkroom(@Param(("type")) String type);

    Workroom findById(long id);

    Boolean deleteById(long id);

    Boolean updateWorkroom(Workroom workroom);


    long insertWorkroom(Workroom workroom);


}
