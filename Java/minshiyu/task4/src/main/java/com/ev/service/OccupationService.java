package com.ev.service;

import com.ev.dao.OccupationDAO;
import com.ev.entity.Occupation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OccupationService {

    List<Occupation> selectOccupation() throws Exception;


}
