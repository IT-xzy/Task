package jnshu.dao;

import org.springframework.stereotype.Repository;
import jnshu.model.Submenu;

import java.util.List;

@Repository
public interface SubmenuMapper {
    int deleteByPrimaryKey(Integer submenuId);

    int insert(Submenu record);

//    int insertSelective(Submenu record);

    Submenu selectByPrimaryKey(Integer submenuId);

    int updateByPrimaryKeySelective(Submenu record);
}