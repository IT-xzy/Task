package com.ev.service;

import com.ev.entity.Occupation;

import java.util.List;

public interface OccupationService {

    List<Occupation> selectOccupation() throws Exception;

    Long addOccupation(Occupation occupation) throws Exception;
}
