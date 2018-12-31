package com.mutesaid.mapper;

import com.mutesaid.pojo.Usr;
import org.apache.ibatis.annotations.Param;

public interface UsrMapper {
    void insert(Usr v);

    Usr select(String value);

    String getPic(String id);

    void setPic(@Param("id") String id, @Param("pic") String pic);
}
