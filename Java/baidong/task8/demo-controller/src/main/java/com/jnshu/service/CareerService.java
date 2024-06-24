package com.jnshu.service;

import com.jnshu.model.Banner;
import com.jnshu.model.Career;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CareerService {
    List<Career> selectAll();
}
