package com.jnshu.service;

import com.jnshu.entity.Profession;

import java.util.List;

public interface ProfessionService {
  List<Profession> getOneByPrimaryKey(long id);
}
