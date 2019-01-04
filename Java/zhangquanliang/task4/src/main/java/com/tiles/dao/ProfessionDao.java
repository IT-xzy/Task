package com.tiles.dao;

import com.tiles.pojo.Profession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/16 22:31
 * 职业的dao 接口
 */
@Repository
public interface ProfessionDao {

    /**
     * 查询各个职业学员
     * @return
     */
    public List<Profession> listProfession();

    /**
     * 各个职业在学弟子人数
     * @return
     */
    public  int getCount();

}
