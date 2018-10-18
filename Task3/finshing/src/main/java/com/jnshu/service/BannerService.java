package com.jnshu.service;

import com.jnshu.entity.Banner;
import com.jnshu.mapper.BannerDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {
    @Autowired
    BannerDao bannerDao;
    //说明：保存一个实体，null的属性也会保存，不会使用数据库默认值
    public int insert(Banner banner){ return bannerDao.insert(banner); }
    //保存一个实体，null的属性不会保存，会使用数据库默认值
    public int insertSelective(Banner banner){ return bannerDao.insertSelective(banner); }

    //说明：根据实体属性作为条件进行删除，查询条件使用等号
    public int delete(Banner banner){ return bannerDao.delete(banner); }
    //根据主键字段进行删除，方法参数必须包含完整的主键属性
    public int deleteByPrimaryKey(Long id){return bannerDao.deleteByPrimaryKey(id);}

    //根据主键更新实体全部字段，null值会被更新
    public int updateByPrimaryKey(Banner banner){return bannerDao.updateByPrimaryKey(banner);}
    //根据主键更新属性不为null的值
    public int updateByPrimaryKeySelective(Banner banner){return bannerDao.updateByPrimaryKey(banner);}

    //根据实体中的属性值进行查询，查询条件使用等号
    public List select(Banner banner){ return  bannerDao.select(banner);}
    //根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
    public Banner selectByPrimaryKey(long id){ return  bannerDao.selectByPrimaryKey(id);}
    //说明：查询全部结果，select(null)方法能达到同样的效果
    public List selectAll(){ return  bannerDao.selectAll();}

    //根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
    public Banner selectOne(Banner banner){ return  bannerDao.selectOne(banner);}
    public int selectCount(Banner banner){ return  bannerDao.selectCount(banner);}

    //根据Example条件进行查询
    //重点：这个查询支持通过 Example 类指定查询列，通过 selectProperties 方法指定查询列
    public List selectByExample(Object example){ return  bannerDao.selectByExample(example);}
    public List selectCountByExample(Object example){ return  bannerDao.selectByExample(example);}

    //根据Example条件更新实体 record 包含的全部属性，null值会被更新
    public int updateByExample(@Param("record") Banner record, @Param("example") Object example){
        return  bannerDao.updateByExample(record, example);}

    // 根据Example条件更新实体 record 包含的不是null的属性值
    public int updateByExampleSelective(@Param("record") Banner record, @Param("example") Object example){
        return  bannerDao.updateByExampleSelective(record, example);}
    //根据Example条件删除数据
    public int deleteByExample(Object example){
        return  bannerDao.deleteByExample(example);}
}
