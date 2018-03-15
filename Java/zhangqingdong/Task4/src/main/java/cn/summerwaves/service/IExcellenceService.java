package cn.summerwaves.service;

import cn.summerwaves.model.Excellence;

import java.util.List;

public interface IExcellenceService {
    List<Excellence> selectExcellenceByName();
}
