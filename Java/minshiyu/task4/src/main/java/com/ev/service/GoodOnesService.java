package com.ev.service;

import com.ev.entity.GoodOne;
import com.ev.entity.StudentGeneralInfo;

import java.util.List;

public interface GoodOnesService {

    List<GoodOne> selectGoodOnes() throws Exception;

}
