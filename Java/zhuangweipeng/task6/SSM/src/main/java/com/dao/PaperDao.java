package com.dao;

import com.pojo.Paper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

//@Repository
public interface PaperDao {
    boolean addPaper(Paper paper);

    boolean deletePaperById(int id);

    boolean updatePaper(Paper paper);

    Paper queryById(int id);

    /**
     * 查询用户记录总数
     * @return
     */
    List<Paper> queryAllPaper();


    /**
     * 根据偏移量查询用户列表
     */
    //List<Paper> queryAllPaper(@Param("offset") int offset, @Param("limit") int limit);
    /**
     * 根据Id获取供应商信息
     * @param id
     * @return
     * @throws Exception
     */
    Paper getPaperById(String id);


    int selectCount();
    /**
     * 分页操作，调用findByPage limit分页方法
     * @param map
     * @return
     */
    List<Paper> findByPage(HashMap<String,Object> map);

}