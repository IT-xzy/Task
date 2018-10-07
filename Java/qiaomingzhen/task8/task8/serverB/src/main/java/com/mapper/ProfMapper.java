package com.mapper;/*
 * @ClassName:ProfMapper
 * @Description:
 * @Author qiao
 * @Date 2018/7/28 14:12
 **/

import com.model.Profession;

import java.util.List;

public interface ProfMapper {
    //    展示修真类型信息
    List<Profession> group();
}
