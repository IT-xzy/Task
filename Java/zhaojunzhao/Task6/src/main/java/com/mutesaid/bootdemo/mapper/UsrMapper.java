package com.mutesaid.bootdemo.mapper;

import com.mutesaid.bootdemo.model.Usr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface UsrMapper {
    void insert(Usr v);

    ArrayList<Usr> select(String value);

    String getPic(String id);

    void setPic(@Param("id") String id, @Param("pic") String pic);

    Usr selectById(Long id);

    Long update(Usr usr);
}
