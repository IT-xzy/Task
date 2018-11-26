package com.ptteng.dao;

import com.ptteng.entity.Profession;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProfessionDao {

    List<Profession> findProfession(@Param("pageStart") Integer pageStart,@Param("size") Integer size);

    Boolean updatePro(Profession profession);

    Long insertPro(Profession profession);

    Boolean deletePro(Long id);

    Profession findOnePro(Long id);

    List<Map<String,Object>> findId(@Param("pageStart") Integer pageStart,@Param("size") Integer size);



}
