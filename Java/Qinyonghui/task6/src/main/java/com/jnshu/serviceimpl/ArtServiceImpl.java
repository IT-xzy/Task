package com.jnshu.serviceimpl;

import org.springframework.stereotype.Service;

@Service
public class ArtServiceImpl {
    /* @Autowired
     ArtDao artDao;
    @Autowired
    ArtMapper artMapper;
     //说明：保存一个实体，null的属性也会保存，不会使用数据库默认值
     public int insert(Art art){ return artDao.insert(art); }
     //保存一个实体，null的属性不会保存，会使用数据库默认值
     public int insertSelective(Art art){ return artDao.insertSelective(art); }

    //说明：根据实体属性作为条件进行删除，查询条件使用等号
    public int delete(Art art){ return artDao.delete(art); }
     //根据主键字段进行删除，方法参数必须包含完整的主键属性
    public int deleteByPrimaryKey(Long id){return artDao.deleteByPrimaryKey(id);}

    //根据主键更新实体全部字段，null值会被更新
    public int updateByPrimaryKey(Art art){return artDao.updateByPrimaryKey(art);}
    //根据主键更新属性不为null的值
    public int updateByPrimaryKeySelective(Art art){return artDao.updateByPrimaryKey(art);}

    //根据实体中的属性值进行查询，查询条件使用等号
     public List select(Art art){ return  artDao.select(art);}
    //根据主键字段进行查询，方法参数必须包含完整的主键属性，查询条件使用等号
     public Art selectByPrimaryKey(long id){ return  artDao.selectByPrimaryKey(id);}
     //说明：查询全部结果，select(null)方法能达到同样的效果
     public List selectAll(){ return  artDao.selectAll();}

    //根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
    public Art selectOne(Art art){ return  artDao.selectOne(art);}
    public int selectCount(Art art){ return  artDao.selectCount(art);}

    //根据Example条件进行查询
    //重点：这个查询支持通过 Example 类指定查询列，通过 selectProperties 方法指定查询列
    public List selectByExample(Object example){ return  artDao.selectByExample(example);}
    public List selectCountByExample(Object example){ return  artDao.selectByExample(example);}

    //根据Example条件更新实体 record 包含的全部属性，null值会被更新
    public int updateByExample(@Param("record") Art record, @Param("example") Object example){
         return  artDao.updateByExample(record, example);}

     // 根据Example条件更新实体 record 包含的不是null的属性值
    public int updateByExampleSelective(@Param("record") Art record, @Param("example") Object example){
        return  artDao.updateByExampleSelective(record, example);}
    //根据Example条件删除数据
    public int deleteByExample(Object example){
        return  artDao.deleteByExample(example);}

    public List<Art> findArtSelective(Art art){
        return  artMapper.findArtSelective(art);}*/
}
