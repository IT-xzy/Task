package com.ev.service;

import com.ev.entity.GoodOne;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

@Remotable
public interface GoodOneService {

    List<GoodOne> selectGoodOne() throws Exception;

    Long addGoodOne(GoodOne goodOne) throws Exception;

}
