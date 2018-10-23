package com.service;

import com.model.Excellent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExcellentService {
    List<Excellent> show();
}
