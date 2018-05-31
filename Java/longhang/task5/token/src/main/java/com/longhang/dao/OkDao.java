package com.longhang.dao;

        import com.longhang.model.User;
        import org.apache.ibatis.annotations.Param;

        import java.util.ArrayList;

public interface OkDao {
    String selectByName(String name);
    Long loginTimeByName(String name);
    ArrayList<String> getAllName();
    User selects(String name);
    void insert(@Param("name")String name,@Param("password")String password,@Param("phone")String phone,@Param("create_at")Long create_at,@Param("logintime")Long logintime);
    void updateByName(@Param("name") String name,@Param("logintime") Long logintime);
    void update(@Param("name")String name,@Param("password")String password,@Param("phone")String phone,@Param("id")Long id);
}
