package com.tiles.service;

import com.tiles.pojo.Profession;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/16 22:33
 * 职业信息的service
 */
public interface ProfessionService {
    /**
     * 查询各个职业
     * @return
     */
    public List<Profession> listProfession();

    /**
     * 各个职业在学弟子人数
     * @return
     */
    public  int getOnlineCount();
}
