package com.jnshu.service;

import com.jnshu.model.ExcellentStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
public interface ESService {
  ExcellentStudent findById(Integer id);
  List<ExcellentStudent> listAll();
}
