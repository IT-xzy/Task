package jnshu.dao;

import org.springframework.stereotype.Repository;
import jnshu.model.People;

import java.util.List;

@Repository
public interface PeopleMapper {
    int deleteByPrimaryKey(Integer peopleId);

    int insert(People record);

//    int insertSelective(People record);

    People selectByPrimaryKey(Integer peopleId);

    int updateByPrimaryKeySelective(People record);

    //    查询艺术家信息
    List selectArtist();
//    int updateByPrimaryKey(People record);

    //    查询成员信息
    List selectWorker();
}