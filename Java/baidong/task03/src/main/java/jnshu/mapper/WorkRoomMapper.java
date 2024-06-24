package jnshu.mapper;

import jnshu.model.User;
import jnshu.model.WorkRoom;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkRoomMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WorkRoom record);

    int insertSelective(WorkRoom record);

    WorkRoom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WorkRoom record);

    int updateByPrimaryKey(WorkRoom record);

    List<WorkRoom> selectByDynamicCondition(@Param("name") String name, @Param("status") Long status);

}