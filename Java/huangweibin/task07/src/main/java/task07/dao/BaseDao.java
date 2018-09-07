package task07.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

//泛型类 ，基础 Dao 接口
public interface BaseDao <T> {
//    只查询一个数据，常用于修改
    public T get(Serializable id);

//    根据条件查询多个结果
    public List<T> find(Map map);

//    插入，用实体作为参数
    public void insert (T entity);

//    修改，用实体作为参数
    public void update (T entity);

//    根据 id 删除对应的数据，支持整形和字符串
    public void deleteById (Serializable id);

//    批量删除，支持整形和字符串类型 id
    public void delete (Serializable[ ] ids);



}
