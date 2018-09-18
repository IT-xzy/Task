package com.service;

import com.pojo.PageBean;
import com.pojo.Paper;

import java.util.List;

public interface PaperService {
    boolean addPaper(Paper paper);

    //删除用户
    boolean deletePaperById(int paperId);

    boolean updatePaper(Paper paper);

    Paper queryById(int id);

    List<Paper> queryAllPaper();

    //List<Paper> queryAllPaper(int offset, int limit);
    int selectCount();

    //分页
    PageBean<Paper> findByPage(int currentPage);

    Paper getPaperById(String paperId);
}
/*

<!--添加-->
<insert id="insertSelective"  parameterType="com.cn.bean.User">
        insert into user(id,name) values(#{id,jdbcType=CHAR},#{name,jdbcType=VARCHAR})
</insert>
<!--查询-->
<select id="selectByPrimaryKey"  resultMap="resultMap">
        select * from user where id=#{id}
</select>
<!--删除-->
<select id="deleteByPrimaryKey"  resultMap="resultMap">
        delete   from user where id=#{id}
</select>*/
