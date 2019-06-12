package jnshu.service.Impl;

import jnshu.model.Relationship;
import jnshu.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    RelationshipService relationshipService;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return relationshipService.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Relationship record) {
        return relationshipService.insert(record);
    }

    @Override
    public int insertSelective(Relationship record) {
        return relationshipService.insertSelective(record);
    }

    @Override
    public Relationship selectByPrimaryKey(Long id) {
        return relationshipService.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Relationship record) {
        return relationshipService.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Relationship record) {
        return updateByPrimaryKeySelective(record);
    }

}
