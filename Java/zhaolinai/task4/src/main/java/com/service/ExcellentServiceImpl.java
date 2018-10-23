package com.service;

import com.mapper.ExcellentMapper;
import com.model.Excellent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ExcellentServiceImpl implements ExcellentService {
  @Autowired
  private   ExcellentMapper excellentMapper;

    @Override
    public List<Excellent> show() {
      return   excellentMapper.show();

    }
}
