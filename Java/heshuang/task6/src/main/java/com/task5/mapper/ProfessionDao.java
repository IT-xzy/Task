package com.task5.mapper;

import com.task5.pojo.Profession;
import java.util.List;

public interface ProfessionDao {
    List<Profession> getAllProfession()throws Exception;
}
