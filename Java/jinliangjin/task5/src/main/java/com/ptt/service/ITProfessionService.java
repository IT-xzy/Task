package com.ptt.service;

import com.ptt.pojo.ITProfession;

import java.util.List;

/**
 * @ProjectName: task4
 * @Package: com.ptt.dao
 * @ClassName: ITProfessionService
 * @Description: Do CRUD to the it_profession table.
 * @Author: Jin
 * @CreateDate: 2018/5/24 10:23
 * @UpdateUser:
 * @UpdateDate: 2018/5/24 10:23
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface ITProfessionService {

    List<ITProfession> query();//查询全部职业
    List<ITProfession> getProfessions(String develop);//分类搜索

}
