package com.fml.service;

import com.fml.pojo.Vocation;
import org.oasisopen.sca.annotation.Remotable;

import java.util.List;

@Remotable
public interface VocationService {
    Vocation getByVocationId(int id);
    int getTotalCount();
    List<Vocation> getAllVocation();
}
