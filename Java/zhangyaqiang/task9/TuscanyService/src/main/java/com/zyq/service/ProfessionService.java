package com.zyq.service;

import com.zyq.pojo.Profession;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

public interface ProfessionService {
    List<Profession> selectAll();
}
