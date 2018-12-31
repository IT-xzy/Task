package com.mutesaid.bootdemo.service;

import com.mutesaid.bootdemo.model.Expert;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpertService {
    List<Expert> findList();
}
