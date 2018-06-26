package com.ev.service;

import com.ev.dao.OccupationDAO;
import com.ev.entity.Occupation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OccupationServiceImpl implements OccupationService{

    @Autowired
    OccupationDAO occupationDAO;

    @Override
    public List<Occupation> selectOccupation() throws Exception {
        return occupationDAO.selectOccupation();
    }
}
