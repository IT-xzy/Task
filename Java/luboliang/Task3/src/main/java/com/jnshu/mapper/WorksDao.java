package com.jnshu.mapper;

import com.jnshu.model.Workss;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorksDao {

    long addWorkss(Workss workss);

    boolean deleteWorkss(long id);

    boolean updateWorkss(Workss workss);

    Workss findByWorkss(long id);

    List<Workss> findAllWorkss();

}
