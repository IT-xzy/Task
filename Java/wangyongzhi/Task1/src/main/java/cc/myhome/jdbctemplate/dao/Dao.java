package cc.myhome.jdbctemplate.dao;

import cc.myhome.model.Network1;
import java.util.List;
import java.util.Map;

public interface Dao {

    //增加一条记录
    public void insert(Network1 stu);
    //根据id更新一条记录
    public void update(long id, Network1 network1);
    //查询所有记录
    public List selectAll();
    //根据id查询单条记录
    public Map selectById(long id);
    //根据id查询记录
    public List selectByName(String name);
}
