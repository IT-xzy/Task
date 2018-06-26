package com.ev.service;

import com.ev.entity.Occupation;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

@Remotable
public interface OccupationService {

    List<Occupation> selectOccupation() throws Exception;

    Long addOccupation(Occupation occupation) throws Exception;
}
