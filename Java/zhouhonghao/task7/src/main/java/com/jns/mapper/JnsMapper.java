package com.jns.mapper;

import com.jns.entity.Jns;

import java.util.List;

public interface JnsMapper {
    //接受返回值，对应xml文件中的sql语句
    //方法名与对应的xml文件中id保持一致
    List<Jns> list();
}
