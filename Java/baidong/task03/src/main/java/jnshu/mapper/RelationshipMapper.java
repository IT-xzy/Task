package jnshu.mapper;

import jnshu.model.Relationship;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    Relationship selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);
}