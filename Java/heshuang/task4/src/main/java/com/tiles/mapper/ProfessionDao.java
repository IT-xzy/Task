package com.tiles.mapper;

import com.tiles.pojo.Profession;
import java.util.List;

public interface ProfessionDao {
    List<Profession> getAllProfession()throws Exception;
}
