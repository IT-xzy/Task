package com.ev.service.implement;

import com.ev.DAO.OccupationDAO;
import com.ev.entity.Occupation;
import com.ev.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("occupationService")
public class OccupationServiceImpl implements OccupationService{

    @Autowired
    OccupationDAO occupationDAO;

    @Override
    public List<Occupation> selectOccupation() throws Exception {
        return occupationDAO.findAllOccupation();
    }

    @Override
    public Long addOccupation(Occupation occupation) throws Exception {
        return occupationDAO.addOccupation(occupation);
    }

}
