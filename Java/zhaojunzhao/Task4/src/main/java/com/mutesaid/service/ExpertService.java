package com.mutesaid.service;

import com.mutesaid.pojo.Expert;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpertService {
    List<Expert> getAllExpert();
}
