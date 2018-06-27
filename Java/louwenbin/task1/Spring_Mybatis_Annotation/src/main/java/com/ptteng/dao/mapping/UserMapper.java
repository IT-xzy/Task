package com.ptteng.dao.mapping;

import com.ptteng.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Insert("insert into step2 (id,create_at,update_at,name,sex,qq,type,admission,graduate,link,wish,audit,understand) " +
            "values (#{id},#{create_at},#{update_at},#{name},#{sex},#{qq},#{type},#{admission},#{graduate},#{link}," +
            "#{wish},#{audit},#{understand})")
    void save(User user);

    @Select("select * from step2 where id = #{id}")
    User getUser(@Param("id") int id);

    @Update("UPDATE step2 SET name=#{name} WHERE id=#{id}")
    boolean updateUser(User user);

    @Delete("DELETE FROM step2 WHERE id = #{id}")
    boolean deleteUser(@Param("id") int id);
}
