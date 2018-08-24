package com.jnshu.service;

import com.jnshu.model.JobInfo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JIService {
  JobInfo findById(Integer id);
  List<JobInfo> listAll();
}
