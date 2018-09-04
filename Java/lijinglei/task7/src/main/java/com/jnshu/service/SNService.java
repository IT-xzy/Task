package com.jnshu.service;

import com.jnshu.model.StudentNum;

import java.util.List;

public interface SNService {
  StudentNum findById(Integer id);
  List<StudentNum> listAll();
}
