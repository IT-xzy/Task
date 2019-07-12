package com.jnshu.service;

import com.jnshu.model.Enterprise;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EnterpriseService {
        List<Enterprise> selectAll();
}
