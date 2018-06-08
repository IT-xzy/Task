package com.spring_mybatis.Category;
import java.util.List;
import org.apache.ibatis.annotations.*;
public interface CategoryDao {
    @Insert("insert into category ( name ) values (#{name})")
    public void insert(Category category);

    @Delete("delete from category where id= #{id}")
    public void delete(int id);

    @Update("update category set name=#{name} where id=#{id}")
    public void update(Category category);

    @Select("select name from   category  where id= #{id}")
    public String get(int id);

    @Select("select * from   category")
    public List<Category> list();
}