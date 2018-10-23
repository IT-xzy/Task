package com.jnshu.service;

import com.jnshu.model.Workss;

import java.util.List;


public interface WorksService {
    public long addWorkss(Workss workss);

    public boolean deleteWorkss(long id);

    public boolean updateWorkss(Workss workss);

    public Workss findByWorkss(long id);

    public List<Workss> findAllWorkss();

}
