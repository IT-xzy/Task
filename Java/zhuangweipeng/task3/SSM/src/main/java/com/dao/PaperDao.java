package com.dao;

import com.pojo.Paper;

import java.util.HashMap;
import java.util.List;

public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);

    /**
     * 查询用户记录总数
     * @return
     */
    List<Paper> queryAllPaper();

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