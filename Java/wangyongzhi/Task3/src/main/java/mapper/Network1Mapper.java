package mapper;

import model.Network1;
import page.Page;

import java.util.List;

public interface Network1Mapper {

    //INSERT插入数据
    int insert(Network1 network1);

    //UPDATE方法：优先根据学生学号更新，其次根据姓名更新数据方法
    int update(Network1 network1);

    //SELECT根据姓名或者学号查询单条数据方法
    Network1 selectByIdName(Network1 network1);

    //根据学生学号删除记录方法
    int deleteById(Long id);

    //SELECT查询全部数据方法
    List<Network1> selectAll();

    //SELECT查询全部数据方法
    List<Network1> selectAll(Page page);

    //提供total方法用于调用xml中对应sql语句
    int total();
}