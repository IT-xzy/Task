package com.ptteng.service;

import com.ptteng.model.Occupation;
import com.ptteng.model.Student;

import java.util.List;

public interface OccupationService {
    List<Occupation> get() throws Exception;
    List<Student> get1() throws Exception;
}
