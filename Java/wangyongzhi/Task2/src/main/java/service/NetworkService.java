package service;

import java.util.List;
import model.Network1;
import page.Page;

public interface NetworkService {

    //INSERT插入数据
    int insert(Network1 network1);

    //UPDATE方法：优先根据学生学号更新，其次根据姓名更新数据方法
    Boolean update(Network1 network1);

    //SELECT根据姓名或者学号查询单条数据方法
    Network1 selectByIdName(Network1 network1);

    //根据学生学号删除记录方法
    Boolean deleteById(Long id);

    //SELECT查询全部数据方法
    List<Network1> selectAll();

    //SELECT查询全部数据方法
    List<Network1> selectAll(Page page);

    //添加分页查询方法
    int total();

}