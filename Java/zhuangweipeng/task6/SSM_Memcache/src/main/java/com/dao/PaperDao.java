package com.dao;

import com.pojo.Paper;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PaperDao {
    int addPaper(Paper paper);

    boolean deletePaperById(long id);

    boolean updatePaper(Paper paper);

    Paper queryById(int id);

    /**
     * 查询用户记录总数
     *
     * @return
     */
    List<Paper> queryAllPaper();

    //根据名字模糊查询
    List<Paper> findPaperByName();

    /**
     * 根据Id获取供应商信息
     *
     * @param id
     * @return
     * @throws Exception
     */
    Paper getPaperById(String id);

    //查询数据总数
    int selectCount();

    /**
     * 分页操作，调用findByPage limit分页方法
     *
     * @param map
     * @return
     */
    List<Paper> findByPage(HashMap<String, Object> map);


}