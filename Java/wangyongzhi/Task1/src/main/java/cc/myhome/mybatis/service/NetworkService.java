package cc.myhome.mybatis.service;
import cc.myhome.model.Network1;
import cc.myhome.model.*;
import org.springframework.stereotype.Component;

import java.util.List;


public interface NetworkService {

    //INSERT插入数据
    int insert(Network1 network1);

    //UPDATE方法：优先根据学生学号更新，其次根据姓名更新数据方法
    Boolean update(Network1 network1);

    //SELECT查询全部数据方法
    List<Network1> selectAll();

    //SELECT根据姓名或者学号查询单条数据方法
    Network1 selectByIdName(Network1 network1);

    //根据学生学号删除记录方法
    Boolean deleteById(Long id);
}