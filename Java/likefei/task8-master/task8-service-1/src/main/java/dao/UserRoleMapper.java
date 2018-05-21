package dao;

import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    void insert(@Param("uid")Long uid, @Param("rid")Long rid);
}
