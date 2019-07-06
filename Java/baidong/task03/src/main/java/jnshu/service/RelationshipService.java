package jnshu.service;

import jnshu.model.Relationship;

import java.util.List;

public interface RelationshipService {
     int deleteByPrimaryKey(Long id);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    Relationship selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);

}
