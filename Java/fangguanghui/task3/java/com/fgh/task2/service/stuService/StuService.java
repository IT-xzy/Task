package com.fgh.task2.service.stuService;

import com.fgh.task2.model.Stu;

import java.util.List;

public interface StuService {

     Integer allCount()throws Exception;
     List<Stu> findOutstanding()throws Exception;
     Integer findWorking()throws Exception;

}
