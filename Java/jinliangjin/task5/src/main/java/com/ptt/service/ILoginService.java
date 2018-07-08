package com.ptt.service;

import com.ptt.pojo.PersistentLogins;

/**
 * @ClassName: ILoginService
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/31 13:42
 * @Version: 1.0
 */
public interface ILoginService {
    PersistentLogins selectByUsernameAndSeries(String username, String series);//通过用户名和UID查询自动登录记录
    PersistentLogins selectByUsername(String username);//通过用户名查询自动登录记录
    void updatePersistentLoginsBySelective(PersistentLogins persistentLogins);//更新记录
    void deletePersistentLoginsByPrimaryKey(int id);
}
