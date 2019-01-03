package com.mutesaid.service;

import org.oasisopen.sca.annotation.Remotable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ProfessionService {
    Map<String, List> findProfessionList();
}
