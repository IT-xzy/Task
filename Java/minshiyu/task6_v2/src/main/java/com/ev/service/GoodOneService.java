package com.ev.service;

import com.ev.entity.GoodOne;

import java.util.List;

public interface GoodOneService {

    List<GoodOne> selectGoodOne() throws Exception;

    void add(GoodOne goodOne) throws Exception;

    Long addGoodOne(GoodOne goodOne) throws Exception;

}
